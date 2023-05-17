package com.miao.compoent;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class JdPageProcessor implements PageProcessor {
    @Override
    public void process(Page page) {
        String level = page.getRequest().getExtra("level").toString();

    }

    @Override
    public Site getSite() {
        return Site.me();
    }
}
