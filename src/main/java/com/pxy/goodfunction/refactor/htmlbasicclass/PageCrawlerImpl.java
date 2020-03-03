package com.pxy.goodfunction.refactor.htmlbasicclass;

public class PageCrawlerImpl implements PageCrawler{
    public WikiPagePath getFullPath(WikiPage suiteSetup){
        return suiteSetup.getPath();
    }
    public static WikiPage getInheritedPage(String suiteSetupName, WikiPage wikiPage) {
        return new WikiPage();
    }
}
