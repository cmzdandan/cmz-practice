package com.cmz.template;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @nickname 陈梦洲
 * @date 2019/3/20 0020
 * @description
 */
public abstract class JdbcTemplate {
    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values) {
        try {
            //1、获取连接
            Connection conn = this.getConnection();
            //2、创建语句集
            PreparedStatement pstm = this.createPrepareStatement(conn,sql);
            //3、执行语句集
            ResultSet rs = this.executeQuery(pstm,values);
            //4、处理结果集
            List<?> result = this.paresResultSet(rs,rowMapper);
            //5、关闭结果集
            this.closeResultSet(rs);
            //6、关闭语句集
            this.closeStatement(pstm);
            //7、关闭连接
            this.closeConnection(conn);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void closeConnection(Connection conn) throws SQLException {
        //数据库连接池，我们不是关闭
        conn.close();
    }

    private void closeStatement(PreparedStatement pstm) throws SQLException {
        pstm.close();
    }

    private void closeResultSet(ResultSet rs) throws SQLException {
        rs.close();
    }

    private List<?> paresResultSet(ResultSet rs, RowMapper<?> rowMapper) throws Exception {
        List<Object> result = new ArrayList<>();
        int rowNum = 1;
        while(rs.next()) {
            result.add(rowMapper.mapRow(rs, rowNum++));
        }
        return result;
    }

    private ResultSet executeQuery(PreparedStatement pstm, Object[] values) throws SQLException {
        for (int i = 0; i < values.length; i++) {
            pstm.setObject(i, values[i]);
        }
        return pstm.executeQuery();
    }

    private PreparedStatement createPrepareStatement(Connection conn, String sql) throws SQLException {
        return conn.prepareStatement(sql);
    }

    public Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }
}
