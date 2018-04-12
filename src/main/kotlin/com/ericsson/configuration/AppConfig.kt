package com.ericsson.configuration

import org.apache.tomcat.jni.SSL.setPassword
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

@Configuration
class AppConfig {
    @Bean
    fun dataSource(): DataSource {
        val ds = DriverManagerDataSource()
        ds.setDriverClassName(com.mysql.jdbc.Driver::class.java!!.getName())
        ds.url = "jdbc:mysql://localhost:3306/dash"
        ds.username = "user"
        ds.password = "password"
        return ds
    }
}