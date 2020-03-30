package com.springBoot.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


// @Configuration：声明我们JdbcConfig是一个配置类
//@PropertySource：指定属性文件的路径是:classpath:jdbc.properties
//通过@Value为属性注入值
//通过@Bean将 dataSource()方法声明为一个注册Bean的方法，Spring会自动调用该方法，将方法的返回值加入Spring容器中。
//然后我们就可以在任意位置通过@Autowired注入DataSource了！

/**
 * 用于jdbc的配置信息
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class jdbcConfig implements EnvironmentAware {

    @Autowired
    private Environment ev;

    @Override
    public void setEnvironment(Environment environment) {
        this.ev = environment;
    }

//    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfiguration.class);

//    @Value("${jdbc.driverClassName}")
//    private String driverClassName;
//    @Value("${jdbc.url}")
//    private String url;
//    @Value("${jdbc.username}")
//    private String username;
//    @Value("${jdbc.maxActive}")
//    private int maxActive;
//    @Value("${jdbc.password}")
//    private String password;
//    @Value("${jdbc.validationQuery}")
//    private String validationQuery;
//    @Value("${jdbc.initialSize}")
//    private int initialSize;
//    @Value("${jdbc.minIdle}")
//    private int minIdle;


    @Bean(name = "dataSource")
    DataSource dataSource() {
        String url = ev.getProperty("jdbc.url");
        String driverClassName = ev.getProperty("jdbc.driverClassName");
        String username = ev.getProperty("jdbc.username");
        String password = ev.getProperty("jdbc.password");
        String validationQuery = ev.getProperty("jdbc.validationQuery");
        Integer initialSize = Integer.valueOf(ev.getProperty("jdbc.initialSize"));
        Integer minIdle = Integer.valueOf(ev.getProperty("jdbc.minIdle"));

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
        ds.setMaxActive(30);
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

    /**
     * 构建会话工厂
     *
     * @return
     */
    @Bean(name = "sqlSessionFactory")
    SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource());
        // 加载本地配置文件
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath:mappers/*Mapper.xml");
        sqlSessionFactoryBean.setMapperLocations(resources);
//        sqlSessionFactoryBean.setConfigLocation(new DefaultResourceLoader().getResource("classpath:config/mybatis-config.xml"));
        return sqlSessionFactoryBean.getObject();

    }

//    /**
//     * 构建扫描设置
//     *
//     * @return
//     */
//    @Bean(name = "mapperScannerConfigurer")
//    MapperScannerConfigurer mapperScannerConfigurer() {
//        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
//        configurer.setBasePackage("com.springBoot.mapper");
//        configurer.setAnnotationClass(Mapper.class);
//        return configurer;
//    }

    /**
     * 事务管理器
     * @return
     */
//    @Bean(name = "transactionManager")
//    public PlatformTransactionManager transactionManager(){
//        return new DataSourceTransactionManager(dataSource());
//    }

//    Properties buildMybatisProperties() throws IOException {
//        Properties prop = new Properties();
//        prop.load(new ClassPathResource("mybatis.properties").getInputStream());
//        return prop;
//    }
}
