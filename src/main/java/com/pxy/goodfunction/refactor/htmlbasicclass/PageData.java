package com.pxy.goodfunction.refactor.htmlbasicclass;

public class PageData {
    public WikiPage getWikiPage(){
        return new WikiPage();
    };

    public boolean hasAttribute(String test){
        return true;
    };

    PageCrawler getPageCrawler(){
        return new PageCrawlerImpl();
    };

    public String getContent() {
        return "hahaha";
    }

    public void setContent(String toString) {
    }

    public String getHtml() {
        return "html";
    }
}
