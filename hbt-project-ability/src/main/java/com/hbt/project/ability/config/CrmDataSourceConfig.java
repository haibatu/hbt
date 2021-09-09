package com.hbt.project.ability.config;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author: hbt
 * @description:
 * @date: created in 10:02 2020/11/13 0013
 * @modified by:
 */
//@Component
public class CrmDataSourceConfig {
    // 数据库连接信息
    @Value("${spring.datasource.druid.crmdb.url}")
    private String url;
    @Value("${spring.datasource.druid.crmdb.username}")
    private String username;
    @Value("${spring.datasource.druid.crmdb.password}")
    private String password;
    @Value("${spring.datasource.druid.crmdb.driver-class-name}")
    private String driverClassName;

    // 连接池连接信息
    @Value("${spring.datasource.druid.crmdb.initialSize}")
    private int initialSize;
    @Value("${spring.datasource.druid.crmdb.minIdle}")
    private int minIdle;
    @Value("${spring.datasource.druid.crmdb.maxActive}")
    private int maxActive;
    @Value("${spring.datasource.druid.crmdb.maxWait}")
    private int maxWait;

    // cbss 数据源
    @Bean(name = "dataSourceCrm")
    @Qualifier("dataSourceCrm")
    public DataSource dataSourceCrm() throws SQLException {
//        OracleXADataSource druidXADataSource = new OracleXADataSource();
//        druidXADataSource.setURL(url);
//        druidXADataSource.setUser(username);
//        druidXADataSource.setPassword(password);
//
//        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
//        xaDataSource.setXaDataSource(druidXADataSource);
//        xaDataSource.setUniqueResourceName("dataSourceCrm");
//        xaDataSource.setPoolSize(3);
//        return xaDataSource;
        DruidXADataSource druidXADataSource = new DruidXADataSource();
        return druidXADataSource;
    }

    /**
     * crm template
     * @param dataSource
     * @return
     */
    @Bean(name = "jdbcTemplateCrm")
    @Qualifier("jdbcTemplateCrm")
    public JdbcTemplate jdbcTemplateCrm(@Qualifier("dataSourceCrm") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
