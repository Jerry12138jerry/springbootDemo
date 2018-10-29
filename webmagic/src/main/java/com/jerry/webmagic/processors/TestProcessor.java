package com.jerry.webmagic.processors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.HttpRequestBody;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.*;

/**
 * @author Jerry
 * @date 2018/10/16
 * 描述：
 */
public class TestProcessor implements PageProcessor {
    private static Logger logger = LoggerFactory.getLogger(TestProcessor.class);
    private static final String URL = "http://mainnet.eoscannon.io/v1/chain/get_block";

    private static Site site = Site.me()
            .setRetryTimes(3)
            .setRetrySleepTime(100)
            .setCharset("utf-8")
            .addHeader("Content-Type", "application/json")
            ;
    private Request request = new Request(URL);
    private Request getRequest() {
        this.request.setMethod(HttpConstant.Method.POST);
        this.request.setRequestBody(HttpRequestBody.json("{'block_num_or_id':5}","utf-8"));
        return this.request;
    }

    @Override
    public void process(Page page) {

    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {

        TestProcessor hanjuTvProcessor = new TestProcessor();
        Spider spider = new Spider(hanjuTvProcessor);
        System.out.println(hanjuTvProcessor.getRequest());
        System.out.println(hanjuTvProcessor.getSite());
        List list = new ArrayList<Request>();
        list.add(0,hanjuTvProcessor.getRequest());
        Spider.create(hanjuTvProcessor).addRequest(hanjuTvProcessor.getRequest()).thread(5).run();
    }

}
