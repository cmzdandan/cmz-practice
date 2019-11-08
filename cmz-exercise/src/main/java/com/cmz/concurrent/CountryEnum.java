package com.cmz.concurrent;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/9/10
 * @description 六国枚举
 */
public enum CountryEnum {
    ONE(1, "齐国"),
    TWO(2, "楚国"),
    THREE(3, "燕国"),
    FOUR(4, "韩国"),
    FIVE(5, "赵国"),
    SIX(6, "魏国"),
    SEVEN(7, "秦国");

    private Integer code;
    private String message;

    CountryEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static CountryEnum getCountry(int index) {
        CountryEnum[] countryEnums = CountryEnum.values();
        for (CountryEnum countryEnum : countryEnums) {
            if (index == countryEnum.getCode()) {
                return countryEnum;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
