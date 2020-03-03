package com.pxy.goodfunction.refactor.htmlbasicclass;

public class WikiPage{

    public WikiPagePath getPath() {
        return new WikiPagePath();
    }

    public PageCrawler getPageCrawler() {
        return new PageCrawlerImpl();
    }
}
