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

/**
 * @author Jerry
 * @date 2018/10/16
 * 描述：模拟post请求
 */
public class PostProcessor  implements PageProcessor {

    private static Logger logger = LoggerFactory.getLogger(PostProcessor.class);

    private String url = "http://mainnet.eoscannon.io/v1/chain/get_block";

    /**
     *  抓取网站的相关配置，包括编码、抓取间隔、重试次数等
     */
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);


    @Override
    public void process(Page page) {

    }

    @Override
    public Site getSite() {
        return site;
    }

    public void get(){

        Request request = new Request(url);
        request.setMethod(HttpConstant.Method.POST);
        request.setRequestBody(HttpRequestBody.json("{'block_num_or_id':5}","utf-8"));

    }
}
