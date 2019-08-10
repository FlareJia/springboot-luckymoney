package com.wlarein.luckymoney.handle;

import com.wlarein.luckymoney.domain.Result;
import com.wlarein.luckymoney.exception.MoneyException;
import com.wlarein.luckymoney.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof MoneyException){
            MoneyException moneyException = (MoneyException) e;
            return ResultUtil.error(moneyException.getCode(), moneyException.getMessage());
        }
        else {
            logger.info("【系统异常 】{}", e);
            return ResultUtil.error(-1, "未知错误");
        }
    }
}