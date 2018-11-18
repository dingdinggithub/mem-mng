package com.kevin.mem.mng.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author 丁海峰
 * @DateTime 2018/11/11 15:45
 * @Description
 */
@Component
public class SwaggerConfig {
    //@Value("${swagger.host}")
    String swaggerHost = "localhost:8001";
    //@Value("${swagger.scheme}")
    String swaggerScheme = "http";
    //@Value("${swagger.basepath}")
    String basepath = "/";


    @Bean
    public Docket createRestApi() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("Kevin's API文档")
                .description("提供给后台管理的API")
                .version("1.0")
                .build();
        Set<String> set = new HashSet<>();
        set.add(swaggerScheme);

        return new Docket(DocumentationType.SWAGGER_2)
                .host(swaggerHost)
                .pathMapping(basepath)
                .protocols(set)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kevin.mem.mng.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
