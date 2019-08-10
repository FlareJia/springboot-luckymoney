package com.wlarein.luckymoney.controller;


import com.wlarein.luckymoney.domain.Luckymoney;
import com.wlarein.luckymoney.repository.LuckymoneyRepository;
import com.wlarein.luckymoney.service.LuckymoneyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckymoneyController {
    private final static Logger logger = LoggerFactory.getLogger(LuckymoneyController.class);

    @Autowired
    private LuckymoneyRepository repository;

    @Autowired
    private LuckymoneyService service;
    /**
     * 获取红包列表
     */
    @GetMapping("/luckymoneys")
    public List<Luckymoney> list(){
        logger.info("list");
        return repository.findAll();
    }

    /**
     * 创建红包(发红包)
     * 用传对象代替传值
     */
    @PostMapping("/luckymoneys")
//  public Luckymoney create(@RequestParam("producer") String producer, @RequestParam("money") BigDecimal money){
    public Luckymoney create(@Valid Luckymoney luckymoney, BindingResult bindingResult){
//        luckymoney.setProducer(producer);
//        luckymoney.setMoney(money);

        if(bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        luckymoney.setProducer(luckymoney.getProducer());
        luckymoney.setMoney(luckymoney.getMoney());
        return repository.save(luckymoney);
    }

    /**
     * 通过id查询红包
     */
    @GetMapping("/luckymoneys/{id}")
    public Luckymoney findById(@PathVariable("id") Integer id){
        return repository.findById(id).orElse(null);
    }

    /**
     * 更新红包（领红包）
     */
    @PutMapping("/luckymoneys/{id}")
    public Luckymoney update(@PathVariable("id") Integer id, @RequestParam("consumer") String consumer){
        Optional<Luckymoney> optional = repository.findById(id);
        if(optional.isPresent()){
            Luckymoney luckymoney = optional.get();
            luckymoney.setConsumer(consumer);
            return repository.save(luckymoney);
        }
        return null;
    }

    @PostMapping("/luckymoneys/two")
    public void createTwo(){
        service.createTwo();
    }
}
