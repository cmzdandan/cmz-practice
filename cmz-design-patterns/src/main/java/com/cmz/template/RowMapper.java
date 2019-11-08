package com.cmz.template;

import java.sql.ResultSet;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/20 0020
 * @description
 */
public interface RowMapper<T> {
    T mapRow(ResultSet rs, int rowNum) throws Exception;
}
