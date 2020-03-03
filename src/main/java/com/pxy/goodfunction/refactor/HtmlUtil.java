package com.pxy.goodfunction.refactor;

import com.pxy.goodfunction.refactor.htmlbasicclass.*;

public class HtmlUtil {
    public static String testableHtml(PageData pageData, boolean includeSuiteSetup) throws Exception {
        //得到wikiPage
        WikiPage wikiPage = pageData.getWikiPage();
        StringBuffer buffer = new StringBuffer();
        if (pageData.hasAttribute("Test")) {
            //判断是否需要全套设置
            if (includeSuiteSetup) {
                //得到suiteSetup类型的wikiPage
                WikiPage suiteSetup = PageCrawlerImpl.getInheritedPage( SuiteResponder.SUITE_SETUP_NAME, wikiPage);
                if (suiteSetup != null) {
                    //得到wikiPage的完整路径
                    WikiPagePath pagePath = suiteSetup.getPageCrawler().getFullPath(suiteSetup);
                    //渲染路径，得到路径名
                    String pagePathName = PathParser.render(pagePath);
                    //把路径名添加到结果buffer中
                    buffer.append("!include -setup .").append(pagePathName).append("\n");
                } }
            //得到Setup类型的wikiPage
            WikiPage setup = PageCrawlerImpl.getInheritedPage("SetUp", wikiPage);
            if (setup != null) {
                //得到wikiPage的完整路径
                WikiPagePath setupPath = wikiPage.getPageCrawler().getFullPath(setup);
                //渲染路径，得到路径名
                String setupPathName = PathParser.render(setupPath);
                //把路径名添加到结果buffer中
                buffer.append("!include -setup .").append(setupPathName).append("\n");
            } }
        //在路径名后添加页面内容
        buffer.append(pageData.getContent());
        if (pageData.hasAttribute("Test")) {
            //得到TearDown类型的wikiPage
            WikiPage teardown = PageCrawlerImpl.getInheritedPage("TearDown", wikiPage);
            if (teardown != null) {
                //得到wikiPage的完整路径
                WikiPagePath tearDownPath = wikiPage.getPageCrawler().getFullPath(teardown);
                //渲染路径，得到路径名
                String tearDownPathName = PathParser.render(tearDownPath);
                //把路径名添加到结果buffer中
                buffer.append("\n").append("!include -teardown .").append(tearDownPathName).append("\n");
            }
            if (includeSuiteSetup) {
                //得到SuiteTeardown类型的wikiPage
                WikiPage suiteTeardown = PageCrawlerImpl.getInheritedPage( SuiteResponder.SUITE_TEARDOWN_NAME, wikiPage);
                if (suiteTeardown != null) {
                    //得到wikiPage的完整路径
                    WikiPagePath pagePath = suiteTeardown.getPageCrawler().getFullPath (suiteTeardown);
                    //渲染路径，得到路径名
                    String pagePathName = PathParser.render(pagePath);
                    //把路径名添加到结果buffer中
                    buffer.append("!include -teardown .").append(pagePathName) .append("\n");
                }
            }
        }
        //在路径后添加页面内容
        pageData.setContent(buffer.toString());
        //返回新得到的html页面
        return pageData.getHtml();
    }

    /**
     * 改进后的代码
     */
    public class SetupAndTeardownIncluder {
        private PageData pageData;
        private StringBuffer newPageContent;
        private WikiPage wikiPage;

        SetupAndTeardownIncluder(PageData pageData) {
            this.pageData = pageData;
            newPageContent = new StringBuffer();
            wikiPage = pageData.getWikiPage();
        }

        public String renderPageWithSetupsAndTeardowns (boolean isSuiteSetup) throws Exception {
            if (isTestPage()) {
                //        if (pageData.hasAttribute("Test")){ //这行判断代码使用isTestPage()函数替代，更易读
                includeSetupAndTeardownPages(isSuiteSetup);
            }
            return pageData.getHtml();
        }
        //增加isTestPage()函数
        private boolean isTestPage() {
            return pageData.hasAttribute("Test");
        }

        private void includeSetupAndTeardownPages(boolean isSuiteSetup) {
            appendSetupPages(isSuiteSetup);
            newPageContent.append(pageData.getContent());

            appendTeardownPages(isSuiteSetup);
            pageData.setContent(newPageContent.toString());
        }

        private void appendTeardownPages(boolean isSuiteSetup) {
            appendPagePathName("TearDown","teardown");
            if (isSuiteSetup) {
                appendPagePathName(SuiteResponder.SUITE_TEARDOWN_NAME,"teardown");
            }
        }

        private void appendSetupPages(boolean isSuiteSetup) {
            if (isSuiteSetup) {
                appendPagePathName(SuiteResponder.SUITE_SETUP_NAME, "setup");
            }
            appendPagePathName("SetUp", "setup");
        }

        private void appendPagePathName(String responderName, String setUpOrTeardown) {
            String pagePathName = getPagePathName(responderName);
            newPageContent.append("!include -").append(setUpOrTeardown).append(" .").append(pagePathName).append("\n");
        }

        private String getPagePathName(String responderName) {
            String pagePathName = "";
            WikiPage responderPage = PageCrawlerImpl.getInheritedPage(responderName, wikiPage);
            if (responderPage != null) {
                WikiPagePath pagePath = responderPage.getPageCrawler().getFullPath (responderPage);
                pagePathName = PathParser.render(pagePath);
            }
            return pagePathName;
        }

    }

}
