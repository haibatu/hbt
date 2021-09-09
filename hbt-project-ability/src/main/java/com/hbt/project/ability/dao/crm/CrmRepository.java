package com.hbt.project.ability.dao.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author: hbt
 * @description:
 * @date: created in 11:04 2020/11/13 0013
 * @modified by:
 */
//@Repository
public class CrmRepository {
    @Autowired
    @Qualifier("jdbcTemplateCrm")
    private JdbcTemplate jdbcTemplateCrm;


}
