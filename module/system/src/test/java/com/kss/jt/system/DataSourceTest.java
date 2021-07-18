package com.kss.jt.system;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
@Slf4j
public class DataSourceTest {
    @Autowired
    private DataSource dataSource;//此对象在springboot启动时已配置

    @Test
    void testGetConnection()throws Exception{
        Connection conn=dataSource.getConnection();
        //System.out.println("conn="+conn);
        log.debug("conn is {}",conn);
    }

}
