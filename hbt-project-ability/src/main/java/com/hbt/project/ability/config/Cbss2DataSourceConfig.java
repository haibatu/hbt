package com.hbt.project.ability.config;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author: hbt
 * @description:
 * @date: created in 16:29 2020/9/29 0029
 * @modified by:
 */
@Configuration
//@EnableJpaRepositories(basePackages = "com.unicom.sitech.cbss.dao", entityManagerFactoryRef = "cbssEntityManagerFactory", transactionManagerRef = "cbssTransactionManager")

public class Cbss2DataSourceConfig {

    // 数据库连接信息
    @Value("${spring.datasource.druid.cbss2db.url}")
    private String url;
    @Value("${spring.datasource.druid.cbss2db.username}")
    private String username;
    @Value("${spring.datasource.druid.cbss2db.password}")
    private String password;
    @Value("${spring.datasource.druid.cbss2db.driver-class-name}")
    private String driverClassName;

    // 连接池连接信息
    @Value("${spring.datasource.druid.cbss2db.initialSize}")
    private int initialSize;
    @Value("${spring.datasource.druid.cbss2db.minIdle}")
    private int minIdle;
    @Value("${spring.datasource.druid.cbss2db.maxActive}")
    private int maxActive;
    @Value("${spring.datasource.druid.cbss2db.maxWait}")
    private int maxWait;

    // cbss 数据源
    @Bean(name = "dataSourceCbss2")
    @Qualifier("dataSourceCbss2")
//    @ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.cbssdb")
    public DataSource dataSourceCbss2() throws SQLException {
        DruidXADataSource druidXADataSource = new DruidXADataSource();
        // 基础连接信息
        druidXADataSource.setUrl(url);
        druidXADataSource.setUsername(username);
        druidXADataSource.setPassword(password);
        druidXADataSource.setDriverClassName(driverClassName);

        // 连接池连接信息
        druidXADataSource.setInitialSize(initialSize);
        druidXADataSource.setMinIdle(minIdle);
        druidXADataSource.setMaxActive(maxActive);
        druidXADataSource.setMaxWait(maxWait);
        druidXADataSource.setPoolPreparedStatements(false); // 是否缓存preparedStatement，也就是PSCache。PSCache对支持游标的数据库性能提升巨大，比如说oracle。在mysql下建议关闭。
        druidXADataSource.setMaxPoolPreparedStatementPerConnectionSize(50);
        druidXADataSource.setConnectionProperties("oracle.net.CONNECT_TIMEOUT=6000;oracle.jdbc.ReadTimeout=60000");// 对于耗时长的查询sql，会受限于ReadTimeout的控制，单位毫秒
        druidXADataSource.setTestOnBorrow(true); // 申请连接时执行validationQuery检测连接是否有效，这里建议配置为TRUE，防止取到的连接不可用
        druidXADataSource.setTestWhileIdle(true);// 建议配置为true，不影响性能，并且保证安全性。申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。
        String validationQuery = "select 1 from dual";
        druidXADataSource.setValidationQuery(validationQuery); // 用来检测连接是否有效的sql，要求是一个查询语句。如果validationQuery为null，testOnBorrow、testOnReturn、testWhileIdle都不会起作用。
        druidXADataSource.setFilters("stat,wall");// 属性类型是字符串，通过别名的方式配置扩展插件，常用的插件有：监控统计用的filter:stat日志用的filter:log4j防御sql注入的filter:wall
        druidXADataSource.setTimeBetweenEvictionRunsMillis(60000); // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        druidXADataSource.setMinEvictableIdleTimeMillis(180000); // 配置一个连接在池中最小生存的时间，单位是毫秒，这里配置为3分钟180000
        druidXADataSource.setKeepAlive(true); // 打开druid.keepAlive之后，当连接池空闲时，池中的minIdle数量以内的连接，空闲时间超过minEvictableIdleTimeMillis，则会执行keepAlive操作，即执行druid.validationQuery指定的查询SQL，一般为select
        // * from
        // dual，只要minEvictableIdleTimeMillis设置的小于防火墙切断连接时间，就可以保证当连接空闲时自动做保活检测，不会被防火墙切断

        druidXADataSource.setRemoveAbandoned(true); // 是否移除泄露的连接/超过时间限制是否回收。
        druidXADataSource.setRemoveAbandonedTimeout(3600); // 泄露连接的定义时间(要超过最大事务的处理时间)；单位为秒。这里配置为1小时
        druidXADataSource.setLogAbandoned(false);  // 移除泄露连接发生是否记录日志


//        OracleXADataSource druidXADataSource = new OracleXADataSource();
//        druidXADataSource.setURL(url);
//        druidXADataSource.setUser(username);
//        druidXADataSource.setPassword(password);

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
//        Properties properties = new Properties();
//        properties.setProperty("URL", url);
//        properties.setProperty("user",username);
//        properties.setProperty("password",password);
//        xaDataSource.setXaProperties(properties);
//        xaDataSource.setXaDataSourceClassName("oracle.jdbc.xa.client.OracleXADataSource");
//        OracleXADataSource druidXADataSource = new OracleXADataSource();
//        druidXADataSource.setURL(url);
//        druidXADataSource.setUser(username);
//        druidXADataSource.setPassword(password);
        xaDataSource.setXaDataSource(druidXADataSource);
//        xaDataSource.setXaDataSourceClassName("com.alibaba.druid.pool.xa.DruidXADataSource");
        xaDataSource.setUniqueResourceName("dataSourceCbss2");
        xaDataSource.setPoolSize(3);
//        xaDataSource.setBorrowConnectionTimeout(30000);
//        xaDataSource.setMinPoolSize(2);
//        xaDataSource.setMaxPoolSize(5);
        return xaDataSource;

    }




//    @Bean(name = "cbssEntityManagerFactory")
//    @Qualifier("cbssEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean cbssEntityManagerFactory(EntityManagerFactoryBuilder entityManagerFactoryBuilder) throws SQLException {
//        LocalContainerEntityManagerFactoryBean entityManagerFactory = entityManagerFactoryBuilder.dataSource(dataSourceCbss())
//                .packages("com.unicom.sitech.domain").persistenceUnit("cbssPersistenceUnit").build();
//        Properties jpaProperties = new Properties();
//        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
//        jpaProperties.put("hibernate.naming.physical-strategy", "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy");
//        jpaProperties.put("hibernate.connection.charSet", "utf-8");
//        jpaProperties.put("hibernate.ddl-auto", "update");
//        jpaProperties.put("hibernate.show_sql", "true");
//        entityManagerFactory.setJpaProperties(jpaProperties);
//        return entityManagerFactory;
//    }
//
//    @Bean(name = "cbssEntityManager")
//    @Qualifier("cbssEntityManager")
//    public EntityManager cbssManager(EntityManagerFactoryBuilder builder) throws SQLException {
//        return cbssEntityManagerFactory(builder).getObject().createEntityManager();
//    }

    /**
     * crm template
     * @param dataSource
     * @return
     */
    @Bean(name = "jdbcTemplateCbss2")
    @Qualifier("jdbcTemplateCbss2")
    public JdbcTemplate jdbcTemplateCbss2(@Qualifier("dataSourceCbss2") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }



//    /**
//     * 返回数据源的事务管理器
//     * @param builder
//     * @return
//     * @throws SQLException
//     */
//    @Bean(name = "cbssTransactionManager")
//    @Qualifier("cbssTransactionManager")
//    public PlatformTransactionManager cbssTransactionManager(EntityManagerFactoryBuilder builder) throws SQLException {
//        return new JpaTransactionManager(cbssEntityManagerFactory(builder).getObject());
//    }

//    /**
//     * 创建事务管理器
//     * @param dataSource
//     * @return
//     */
//    @Bean(name = "cbssTransactionManager")
//    public DataSourceTransactionManager cbssTransactionManager(@Qualifier("dataSourceCbss") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }

}
