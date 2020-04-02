package com.zcw.test;

import com.zcw.controller.SampleController;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @ClassName : TestSampleController
 * @Description : 创建测试类
 * @Author : Zhaocunwei
 * @Date: 2020-04-02 15:48
 */
@SpringBootTest(classes= SampleController.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestSampleController {
    @Autowired
    private SampleController sampleController;
    @Test
    public void testHome(){
        TestCase.assertEquals(this.sampleController.home(),"https://blog.csdn.net/qq_32370913");
    }
}
