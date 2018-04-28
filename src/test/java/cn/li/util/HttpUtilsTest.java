package cn.li.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class HttpUtilsTest {
    @Test
    public void sendGet(){
        String result = HttpUtils.sendGet("2016211883");
        System.out.println(result);
    }
}
