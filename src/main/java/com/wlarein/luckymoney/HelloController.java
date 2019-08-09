package com.wlarein.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private LimitConfig limitConfig;

    // 这种使用 /say/100 来访问
    @GetMapping("/say/{id}")
    public String say(@PathVariable("id") Integer id){
        //return "说明："+ limitConfig.getDescription();
        //return "index";
        return "id: "+ id;
    }
    // 这种使用 /say?id=100 来访问
    @GetMapping("/say")
    public String say2(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId){
        return "id: "+ myId;
    }
}
