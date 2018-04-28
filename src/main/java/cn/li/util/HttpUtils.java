package cn.li.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 发送http请求
 * @param studentNum
 */
public class HttpUtils {
    private static final String TARGETURL = "https://we.cqu.pt/api/others/student.php?key=STUDENTNUM";

    public static String sendGet(String studentNum){
        String url = TARGETURL.replace("STUDENTNUM",studentNum);
        //获取httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //生成一个get请求
        HttpGet httpGet =new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            //执行get请求并返回结果
            response = httpClient.execute(httpGet);
            System.out.println(response);
        }catch (IOException e1){
            e1.printStackTrace();
        }
        String result = null;
        try {
            //处理结果为字符串
            HttpEntity entity = response.getEntity();
            if(entity!=null){
                result = EntityUtils.toString(entity);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                response.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return result;
    }
}
