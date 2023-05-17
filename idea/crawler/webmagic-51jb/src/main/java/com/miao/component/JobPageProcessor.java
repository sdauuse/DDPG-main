package com.miao.component;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

@Component
public class JobPageProcessor implements PageProcessor {
    @Override
    public void process(Page page) {
        //判断是列表页面还是详情页面
        Html html = page.getHtml();

        List<Selectable> nodes = html.css("div.e ").nodes();
        //列表页面
        if (nodes.size() > 0) {
            for (Selectable node : nodes) {

            }
        }
    }

    @Override
    public Site getSite() {
        return Site.me();
    }
}
