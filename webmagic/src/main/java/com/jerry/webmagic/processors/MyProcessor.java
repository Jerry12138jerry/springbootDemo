package com.jerry.webmagic.processors;

import com.jerry.webmagic.server.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
/**
 * @author Jerry
 * @date 2018/10/12
 */
@EnableScheduling
@Configuration
public class MyProcessor implements PageProcessor {

    private static Logger logger = LoggerFactory.getLogger(MyProcessor.class);

    /**
     *  抓取网站的相关配置，包括编码、抓取间隔、重试次数等
     */
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    private static int count =0;

    /**
     * url
     */
    String url = "https://gateio.io/ref/625612";

    /**
     * 资源
     */
    String xpath = "//*[@id=\"eos_usdt\"]/td[2]/span";

    @Override
    public void process(Page page) {
        logger.info("抓取的内容："+page.getHtml().xpath(xpath).get());
        String str = page.getHtml().xpath(xpath).get();
        String[] prices = str.trim().split(">");
        String price2 = prices[1];
        String[] prices2 = price2.trim().split("</");
        String price = prices2[0];
        logger.info("现在eos的价格为"+price);
        count ++;
        for(WebSocketServer webSocketServer :WebSocketServer.webSockets){
            try {
                webSocketServer.send("现在EOS的价格是"+price);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
        Spider.create(new MyProcessor()).addUrl(url).thread(5).run();
        endTime = System.currentTimeMillis();
        logger.info("爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒，抓取了"+count+"条记录");
        logger.info("每1秒执行一次,结束");
    }
}
