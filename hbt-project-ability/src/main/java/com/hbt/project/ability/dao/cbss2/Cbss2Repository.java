package com.hbt.project.ability.dao.cbss2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author:hbt
 * @description:
 * @date: created in 15:31 2020/9/16 0016
 * @modified by:
 */

@Repository
public class Cbss2Repository {

    @Autowired
    @Qualifier("jdbcTemplateCbss2")
    private JdbcTemplate jdbcTemplateCbss2;
    /**
     * 测试
     * @return
     */
    public int test() {
        String sql = "select * from batch_result a ";
        return jdbcTemplateCbss2.queryForList(sql).size();
    }
}
