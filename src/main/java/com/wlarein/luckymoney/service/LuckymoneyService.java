package com.wlarein.luckymoney.service;

import com.wlarein.luckymoney.domain.Luckymoney;
import com.wlarein.luckymoney.exception.MoneyException;
import com.wlarein.luckymoney.repository.LuckymoneyRepository;
import enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;

@Service
public class LuckymoneyService {

    @Autowired
    private LuckymoneyRepository repository;

    /**
     * 事务 指的是数据库的事务
     */
    @Transactional
    public void createTwo(){
        Luckymoney luckymoney1 = new Luckymoney();
        luckymoney1.setProducer("郑嘉");
        luckymoney1.setMoney(new BigDecimal("520"));
        repository.save(luckymoney1);

        Luckymoney luckymoney2 = new Luckymoney();
        luckymoney2.setProducer("郑嘉");
        luckymoney2.setMoney(new BigDecimal("1314"));
        repository.save(luckymoney2);
    }

    public void getMoney(Integer id) throws Exception{
        Luckymoney luckymoney = repository.findById(id).get();
        BigDecimal money = luckymoney.getMoney();
        if(money.compareTo(new BigDecimal("200"))==-1){
            // 返回 小红包
            throw new MoneyException(ResultEnum.LittleMoney);
        }
        else if(money.compareTo(new BigDecimal("500"))==-1){
            // 返回 大红包
            throw new MoneyException(ResultEnum.BigMoney);
        }

    }

    /**
     * 通过id查询一个红包
     * @param id
     * @return
     */
    public Luckymoney findOne(Integer id){
        return repository.findById(id).get();
    }
}
