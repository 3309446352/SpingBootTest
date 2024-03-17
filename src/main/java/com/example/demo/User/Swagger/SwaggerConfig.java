package com.example.demo.User.Swagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 // 启用 Swagger
@EnableWebMvc
public class SwaggerConfig{

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())// 用于定义 api 文档汇总信息
                .select()//
                // 为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.xpf.imoney"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 构建 api 文档的详细信息函数，注意这里的注解引用的是哪个
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 页面标题
                .title("SSM Application [iMoney] Swagger2 RESTFul API")
                // 创建人
                .contact(new Contact("x-sir", "http://www.x-sir.com", "542270559@qq.com"))
                .description("API 文档")// 描述
                .termsOfServiceUrl("http://www.x-sir.com")// 服务网址
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                // 版本号
                .version("1.0")
                // 描述
                .description("This is [iMoney] API doc")
                .build();
    }
    @Bean
    public Docket docket() {
        // 创建一个 swagger 的 bean 实例
        return new Docket(DocumentationType.SWAGGER_2)

                // 配置接口信息
                .select() // 设置扫描接口
                // 配置如何扫描接口
                .apis(RequestHandlerSelectors
                                //.any() // 扫描全部的接口，默认
                                //.none() // 全部不扫描
                                .basePackage("com.duojiala.mikeboot.controller") // 扫描指定包下的接口，最为常用
                        //.withClassAnnotation(RestController.class) // 扫描带有指定注解的类下所有接口
                        //.withMethodAnnotation(PostMapping.class) // 扫描带有只当注解的方法接口

                )
                .paths(PathSelectors
                                .any() // 满足条件的路径，该断言总为true
                        //.none() // 不满足条件的路径，该断言总为false（可用于生成环境屏蔽 swagger）
                        //.ant("/user/**") // 满足字符串表达式路径
                        //.regex("") // 符合正则的路径
                )
                .build();
    }
    /**
     * swagger 配置
     * @param environment 环境
     */
    @Bean
    public Docket docket(Environment environment) {

        // 设置环境范围
        Profiles profiles = Profiles.of("dev","test");
        // 如果在该环境返回内则返回：true，反之返回 false
        boolean flag = environment.acceptsProfiles(profiles);

        // 创建一个 swagger 的 bean 实例
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(flag) // 是否开启 swagger：true -> 开启，false -> 关闭
                ;
    }

}
