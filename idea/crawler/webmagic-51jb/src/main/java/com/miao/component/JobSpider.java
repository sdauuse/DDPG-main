package com.miao.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;

@Component
public class JobSpider {

    private String startUrl = "";

    @Autowired
    private JobPageProcessor jobPageProcessor;

    @Autowired
    private JobPipeline jobPipeline;
    /**
     * 初始化爬虫
     */
    public  void doCrawler(){
        Spider.create(jobPageProcessor)
                .addUrl(startUrl)
                .addPipeline(jobPipeline)
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(10000000)))
                .start();
    }
}
