#1.class SwaggerConfig

```java
/**
 * Swagger API文档相关配置
 * Created by macro on 2018/4/26.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.macro.mall.auth.controller")
                .title("mall认证中心")
                .description("mall认证中心相关接口文档")
                .contactName("macro")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
```