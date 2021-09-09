package com.hbt.project.ability.dao.cbss1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author:hbt
 * @description:
 * @date: created in 16:07 2020/9/21 0021
 * @modified by:
 */
@Repository
public class Cbss1Repository {

    @Autowired
    @Qualifier("jdbcTemplateCbss1")
    private JdbcTemplate jdbcTemplateCbss1;


    /**
     * 测试
     * @return
     */
    public int test() {
        String sql = "select * from ucr_crm1.tf_b_trade_develop a ";
        return jdbcTemplateCbss1.queryForList(sql).size();
    }
}
