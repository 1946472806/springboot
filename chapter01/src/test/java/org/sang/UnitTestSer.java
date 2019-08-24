package org.sang;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sang.service.UnitTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitTestSer {
    @Autowired
    UnitTestService unitTestService;

    @Test
    public void contextLoads() {
        String re_test = unitTestService.unitTest("胡歌");
        Assert.assertThat(re_test, Matchers.is("Test~胡歌~"));
    }
}
