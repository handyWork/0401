package com.springBoot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;


@Configuration
@PropertySource("classpath:jdbc.properties")
public class jdbcConfig {


//    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfiguration.class);

    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.validationQuery}")
    private String validationQuery;
    @Value("${jdbc.initialSize}")
    private int initialSize;
    @Value("${jdbc.minIdle}")
    private int minIdle;
    @Value("${jdbc.maxActive}")
    private int maxActive;


    @Bean(name = "dataSource")
    DataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driverClassName);
        //设置链接地址
        ds.setUrl(url);
        //设置用户名
        ds.setUsername(username);
        //设置密码
        ds.setPassword(password);
        //设置验证查询
        ds.setValidationQuery(validationQuery);
        //单位：秒，检测连接是否有效的超时时间。底层调用jdbc Statement对象的void setQueryTimeout
        ds.setValidationQueryTimeout(600);
        //初始化大小
        ds.setInitialSize(initialSize);
        ds.setMinIdle(minIdle);
        ds.setMaxActive(maxActive);
        //配置获取连接等待超时的时间
        ds.setMaxWait(60000);
        //配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        ds.setTimeBetweenEvictionRunsMillis(60000);
        //配置一个连接在池中最小生存的时间，单位是毫秒
        ds.setMinEvictableIdleTimeMillis(200000);
        ds.setTestWhileIdle(true);
        //这里建议配置为TRUE，防止取到的连接不可用
        ds.setTestOnBorrow(false);
        ds.setTestOnReturn(false);
        //打开PSCache，并且指定每个连接上PSCache的大小
        ds.setPoolPreparedStatements(true);
        //配置每个链接最大打开的Statement数量
        ds.setMaxPoolPreparedStatementPerConnectionSize(20);
        //这里配置提交方式，默认就是TRUE，可以不用配置
        ds.setDefaultAutoCommit(true);
        //超过时间限制是否回收
        ds.setRemoveAbandoned(false);
        //回收超时时间；单位为秒。180秒=3分钟
        ds.setRemoveAbandonedTimeout(60);
        //关闭abanded连接时输出错误日志
        ds.setLogAbandoned(true);
        return ds;
    }


}
