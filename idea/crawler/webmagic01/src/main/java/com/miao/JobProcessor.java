package com.miao;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;

public class JobProcessor implements PageProcessor {

    /**
     * 解析页面
     *
     * @param page
     */
    @Override
    public void process(Page page) {
        //解析返回的数据page，并且将解析的结果放到ResultItems中
        //page.putField("div", page.getHtml().xpath("//*[@id=/"channel/"]/a").all());

        page.putField("div", page.getHtml().xpath("//div[@id=shortcut-2014]/div/ul/li/div/a/text()"));

        page.putField("title", page.getHtml().css("div.dt > a").get());

        page.putField("div2", page.getHtml().xpath("//*[@id=\"shortcut-2014\"]/div/ul[2]/li[3]/div/a/text()"));

        page.putField("div3",page.getHtml().xpath("/html/body/div[12]/div[1]/div[1]/ul[1]/li[1]/a/b/text()").all());

        //获取超链接
        page.putField("gud",page.getHtml().links());
        page.addTargetRequest(page.getHtml().links().get());
        page.putField("mainPage",page.getHtml().xpath("//*[@id=\"J_seckill\"]/div/div/div[1]/div/div/div/a[1]/h6/text()"));
    }

    private Site site = Site.me()
            .setCharset("utf8")
            .setTimeOut(10 * 1000) //设置超时时间 单位为毫秒
            //.setRetrySleepTime() //设置重试的间隔时间
            //.setSleepTime(3)  //设置重试次数
            //.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.100 Safari/537.36")
            ;

    /**
     * Site就是站点的配置
     * 返回默认配置  Site.me()
     * @return
     */
    @Override
    public Site getSite() {
        // 添加一个请求头
        site.addHeader("UserAgent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.99 Safari/537.36 Edg/97.0.1072.76");
        return site;
    }

    //主函数执行爬虫
    public static void main(String[] args) {
        Spider.create(new JobProcessor())
                .addUrl("https://kuaibao.jd.com/")
//                .addUrl("https://oas.gdut.edu.cn/seeyon/main.do?method=main&loginPortal=1&portalId=-7779029842361826066")
//                .addUrl("https://www.sina.com.cn/")
//                .addPipeline(new FilePipeline("D:\\webmagic")) //将控制台的信息输出到本地文件中
                .thread(5) //设置5个多线程
                //.setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover()))
                .run();
    }
}
