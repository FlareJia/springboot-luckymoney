package com.wlarein.luckymoney;

import com.wlarein.luckymoney.domain.Luckymoney;
import com.wlarein.luckymoney.service.LuckymoneyService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

// @RunWith注解表示我们要在测试环境里面跑，底层是junit
@RunWith(SpringRunner.class)
// @SpringBootTest表示将启动整个springboot工程
@SpringBootTest
public class LuckymoneyServiceTest {
    @Autowired
    private LuckymoneyService luckymoneyService;

    @Test
    public void findOneTest(){
        Luckymoney luckymoney =luckymoneyService.findOne(18);
        Assert.assertEquals(new BigDecimal("100.00"), luckymoney.getMoney());
    }
}
