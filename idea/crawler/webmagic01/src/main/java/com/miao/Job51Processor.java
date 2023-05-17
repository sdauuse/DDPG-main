package com.miao;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import javax.annotation.processing.Processor;
import java.util.List;

public class Job51Processor implements PageProcessor {
    @Override
    public void process(Page page) {
        //判断是列表页面还是详情页面
        Html html = page.getHtml();

        List<Selectable> nodes = html.css("div.e ").nodes();

        page.putField("ss",html);
        //列表页面
        if (nodes.size() > 0) {
            for (Selectable node : nodes) {
                System.out.println("1");
            }
        }
    }

    @Override
    public Site getSite() {
        return Site.me();
    }

    public static void main(String[] args) {
        Spider.create(new Job51Processor())
                .addUrl("https://search.51job.com/list/030200%252c040000,000000,0000,01%252c32,9,99,java,2,1.html?lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&ord_field=0&dibiaoid=0&line=&welfare=");
    }
}
