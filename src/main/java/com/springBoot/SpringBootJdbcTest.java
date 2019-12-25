package com.springBoot;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 用来测试是否连接上数据库
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJdbcTest {

    @Autowired
    DataSource dataSource;

    public void contextLoads() throws SQLException {
        System.err.println(dataSource.getClass());

        Connection connection = dataSource.getConnection();
        System.err.println(connection);
        connection.close();

    }

}
