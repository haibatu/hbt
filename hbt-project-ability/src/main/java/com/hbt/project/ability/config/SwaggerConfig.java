package com.hbt.project.ability.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: hbt
 * @description:
 * @date: created in 17:11 2020/11/13 0013
 * @modified by:
 */

@EnableSwagger2
@Configuration
public class SwaggerConfig {


    @Bean(value = "aoam")
    public Docket adminApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("aoam")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.unicom.microserv.aoam.web"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("CBSS支撑系统:省份个性化@接口文档")
                .description("CBSS支撑系统-省份个性化")
                .termsOfServiceUrl("http://127.0.0.1:8089/doc.html")
//                .contact("developer@mail.com")
                .version("1.0")
                .build();
    }
}
