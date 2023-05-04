package vertx;

import io.vertx.core.Vertx;
import io.vertx.ext.web.client.WebClient;

public class VertxClient {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        WebClient webClient = WebClient.create(vertx);
                webClient
                        .post(9181, "activitytest.zlongame.com","/activity/cmn/card/consume.do")
//                        .post(80, "www.baidu.com","")
//                .putHeader("content-type", "application/x-www-form-urlencoded")
//                .addQueryParam("appkey","1656417299073")
//                .addQueryParam("card_user", "23")
//                .addQueryParam("card_channel","AAAAAAAAAA")
//                .addQueryParam("card_server","1001")
//                .addQueryParam("card_code", "N6SW7Y4GY")
//                .addQueryParam("card_role", "49")
//                .addQueryParam("sign","11111111111111")
//                .addQueryParam("ip", "10.0.23.1")
//                        .postAbs("http://activitytest.zlongame.com:9181/activity/cmn/card/consume.do")
                .send().onSuccess(httpResponse -> {
                    System.out.println(httpResponse.body());
                });
        System.out.println("hello world");
//                webClient.postAbs()
    }
}
