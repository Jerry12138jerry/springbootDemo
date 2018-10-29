package com.jerry.webmagic.processors;

import com.jerry.webmagic.server.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.HttpRequestBody;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.utils.HttpConstant;

/**
 * @author Jerry
 * @date 2018/10/12
 */
@EnableScheduling
@Configuration
public class EosProcessor implements PageProcessor {

    private static Logger logger = LoggerFactory.getLogger(EosProcessor.class);

    /**
     *  抓取网站的相关配置，包括编码、抓取间隔、重试次数等
     */
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100).setCharset("utf-8");
    private static int count =0;

    /**
     * url
     */
    String url = "http://mainnet.eoscannon.io/v1/chain/get_block";
    @Override
    public void process(Page page) {
    }

    @Override
    public Site getSite() {
        return site;
    }

    @Scheduled(fixedRate=1000)
    public void test(){
        logger.info("每1秒执行一次,开始");
        long startTime, endTime;
        startTime = System.currentTimeMillis();
        Request request = new Request(url);
        request.setMethod(HttpConstant.Method.POST);
        request.setRequestBody(HttpRequestBody.json("{'block_num_or_id':5}","utf-8"));
        Spider.create(new EosProcessor()).addRequest(request).thread(5).run();
        endTime = System.currentTimeMillis();
        logger.info("爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒，抓取了"+count+"条记录");
        logger.info("每1秒执行一次,结束");
    }
}
