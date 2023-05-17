package com.miao.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miao.pojo.Item;
import com.miao.service.ItemService;
import com.miao.utils.HttpUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Component
public class ItemTask {
    @Autowired
    private ItemService itemService;

    @Autowired
    HttpUtils httpUtils;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    //当我们的下载任务完成后，间隔多长时间进行下一次的任务，单位为毫秒
    @Scheduled(fixedDelay = 100 * 1000)
    public void itemTask() throws Exception {
        String url = "https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&wq=%E6%89%8B%E6%9C%BA&pvid=a4e98d3a07b943e49311cb376ea6335c&s=1&click=0&page=";


        //按照页码对手机的搜索结果进行遍历和解析
        for (int i = 1; i < 10; i = i + 2) {
            String url_new = url + i;
            String html = httpUtils.doGetHtml(url_new);

            //解析页面，获取商品数据并且存储
            parse(html);

        }

        System.out.println("手机数据抓取完成");
    }


    private void parse(String html) throws IOException {
        //解析html获取Document
        Document doc = Jsoup.parse(html);

        //获取spu
        Elements spuEles = doc.select("div#J_goodsList > ul > li");

        for (Element spuEle : spuEles) {
            // 排除没有data-spu的值的广告
            if (StringUtils.isNotEmpty(spuEle.attr("data-spu"))) {
                //获取spu
                Long spu = Long.parseLong(spuEle.attr("data-spu"));

                //获取sku
                Elements skuElems = spuEle.select("li.ps-item");
                for (Element skuElem : skuElems) {
                    Long sku = Long.parseLong(skuElem.select("[data-sku]").attr("data-sku"));

                    //根据sku查询商品数据，如果商品存在则进行下一次循环，该商品不保存
                    Item item = new Item();
                    item.setSku(sku);
                    List<Item> list = itemService.findAll(item);

                    if (list.size() > 0) {
                        continue;
                    }

                    //设置商品的spu
                    item.setSpu(spu);

                    //获取商品的详情的url
                    String itemUrl = "https://item.jd.com/" + sku + ".html";
                    item.setUrl(itemUrl);

                    //获取商品的图片
                    String picUrl = "https:" + skuElem.select("img[data-sku]").first().attr("data-lazy-img");
                    picUrl = picUrl.replace("/n7/", "/n0/" );
                    String picName = this.httpUtils.doGetImage(picUrl);
                    item.setPic(picName);

                    //获取商品的价格
                    String priceJson = httpUtils.doGetHtml("https://p.3.cn/prices/mgets?skuIds=J_" + sku);
                    double price = MAPPER.readTree(priceJson).get(0).get("p").asDouble();
                    item.setPrice(price);


                    // 获取商品的标题
                    String itemInfo = this.httpUtils.doGetHtml(item.getUrl());
                    String title = Jsoup.parse(itemInfo).select("div.sku-name").text();
                    item.setTitle(title);
                    //item.setTitle();
                    item.setCreated(new Date());
                    item.setUpdated(item.getCreated());

                    // 保存商品数据到数据库中
                    this.itemService.save(item);


                    item.setCreated(new Date());
                    item.setUpdated(item.getCreated());
                }
            }
        }
    }
}
