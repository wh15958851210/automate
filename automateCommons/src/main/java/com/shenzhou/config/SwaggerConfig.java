package com.shenzhou.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //配置了docker的bean实例
    @Bean
    public Docket docket(Environment environment){
        //配置只在开发环境和测试环境才能启用swagger
        Profiles profiles = Profiles.of("dev","test");
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("万涵")
                .apiInfo(apiInfo())
                //.enable(flag)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.shenzhou.controller"))
                .build();
    }
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    //配置api
    private ApiInfo apiInfo(){
        Contact automateContact = new Contact("万涵","","");
        return new ApiInfo("Automate-Api",
                           "Api 自动化接口",
                           "1.0",
                           "",
                            automateContact,
                           "",
                           "",
                            new ArrayList());
    }

}
