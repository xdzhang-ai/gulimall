package com.chffy.gulimall.thirdparty;

import com.aliyun.oss.OSSClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallThirdPartyApplicationTests {

    @Resource
    private OSSClient ossClient;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testOss() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("/Users/winter/Downloads/e13ab3af5dbe76d85aa1b8980a2da744.jpeg");
        ossClient.putObject("gulimall-chffy", "haha.jpg", inputStream);
        ossClient.shutdown();

        System.out.println("上传成功");
    }

}
