package com.tan.config.knif4j;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class KnIf4jConfig {
    @Bean
    public Docket adminApiConfig() {
        List<RequestParameter> pars = new ArrayList<>();
        RequestParameterBuilder tokenPar = new RequestParameterBuilder();
        tokenPar.name("token")
                .description("用户token")
                .query(q -> q.defaultValue("").model(m -> m.scalarModel(ScalarType.STRING)))
                .in(ParameterType.HEADER)
                .required(false)
                .build();
        pars.add(tokenPar.build());
        //添加head参数end

        Docket adminApi = new Docket(DocumentationType.SWAGGER_2)
                .groupName("adminApi")
                .apiInfo(adminApiInfo())
                .select()
                //只显示admin路径下的页面
                .apis(RequestHandlerSelectors.basePackage("com.tan"))
                .paths(PathSelectors.regex("/admin/.*"))
                .build()
                .globalRequestParameters(pars);
        return adminApi;
    }

    private ApiInfo adminApiInfo() {

        return new ApiInfoBuilder()
                .title("后台管理系统-API文档")
                .description("本文档描述了后台管理系统微服务接口定义")
                .version("1.0")
                .contact(new Contact("tan", "http://tsxxy.top", "ts20010411@163.com"))
                .build();
    }
}