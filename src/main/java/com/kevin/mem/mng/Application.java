package com.kevin.mem.mng;

import com.alibaba.druid.pool.DruidDataSource;
import com.kevin.mem.mng.utils.JsonUtils;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author 丁海峰
 * @DateTime 2018/11/12 22:04
 * @Description
 */
@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = "com.kevin.mem.mng.domain.mapper")
public class Application {
    private Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DruidDataSource druidConfig() {
        return new DruidDataSource();
    }

    @Bean
    public DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean(@Value("classpath*:dozer/*-mapper.xml") Resource[] resources) throws Exception {
        final DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean = new DozerBeanMapperFactoryBean();
        dozerBeanMapperFactoryBean.setMappingFiles(resources);
        return dozerBeanMapperFactoryBean;
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        jsonConverter.setObjectMapper(JsonUtils.OBJECT_MAPPER);
        return jsonConverter;
    }
}
