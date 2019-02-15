package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example"))   //开启了@EnableSwagger2就会扫描com.xuecheng包下所有定义了@RestController注解的类，包括其中的方法，地址
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("Jason","http://www.example.com","xieyue.410686417@qq.com");
        return new ApiInfoBuilder()
                .title("Springcloud案例的api文档")
                .description("Springcloud案例的api文档")
                .contact(contact)
                //.contact("jason")//termsOfServiceUrl和contact可以用Contact的对象代替,Contact对象中name表示作者，url通常作为项目的链接，代替之前的termsOfServiceUrl方法，email为联系地址
                //.termsOfServiceUrl("/")
                .version("1.0")
                .build();
    }



}
