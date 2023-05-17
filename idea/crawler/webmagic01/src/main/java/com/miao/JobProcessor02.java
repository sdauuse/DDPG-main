package com.miao;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

public class JobProcessor02 implements PageProcessor {

    /**
     * 页面分析
     * 组件Pipeline，框架提供了三个实现：
     * ConsolePipeline：向控制台输出,默认使用
     * FilePipeline: 向磁盘文件中输出
     * JsonFilePipeline: 保存json格式的文件
     * 自定义Pipeline,保存到数据库中
     * @param page 下载的结果封装成Page对象
     */
    @Override
    public void process(Page page) {
        Html html = page.getHtml();
        //把结果输出到控制台
        //ResultItems就是把解析的结果传递给Pipeline
        /*ResultItems resultItems = page.getResultItems();
        resultItems.put("html", html);*/


        page.putField("html", html);

        String s = html.xpath("/html/body/div[1]/div[4]/div/div[1]/h2/text()").get();
        page.putField("s", s);
        //page.addTargetRequest();//向scheduler对象添加url

        List<String> all = html.css("ul.ulon > li > a","href").all();
        page.putField("all", all);
    }


    /**
     * Site就是站点的配置
     * 返回默认配置  Site.me()
     *
     * @return
     */
    @Override
    public Site getSite() {
        return Site.me();
    }

    public static void main(String[] args) {
        //指定队列使用布隆过滤器
        QueueScheduler scheduler = new QueueScheduler();
        //参数是类似于位图的容量
        scheduler.setDuplicateRemover(new BloomFilterDuplicateRemover(10000000));

        Spider.create(new JobProcessor02())
                .addUrl("https://www.itcast.cn/")
                .run();
    }
}
