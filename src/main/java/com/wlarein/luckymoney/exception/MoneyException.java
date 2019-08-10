package com.wlarein.luckymoney.exception;

import enums.ResultEnum;

/**
 * 继承RuntimeException是因为spring对Exception不会事务回滚，对RuntimeException会事务回滚
 */
public class MoneyException extends RuntimeException {
    private Integer code;

    public MoneyException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
