#1.class ResourceServerConfig

```
springSecurityFilterChain
--http.oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthenticationConverter());
--//自定义处理JWT请求头过期或签名错误的结果
--http.oauth2ResourceServer().authenticationEntryPoint(restAuthenticationEntryPoint);
--//对白名单路径，直接移除JWT请求头
--http.addFilterBefore(ignoreUrlsRemoveJwtFilter,SecurityWebFiltersOrder.AUTHENTICATION);
--http.authorizeExchange()
                .pathMatchers(ArrayUtil.toArray(ignoreUrlsConfig.getUrls(),String.class)).permitAll()//白名单配置
                .anyExchange().access(authorizationManager)//鉴权管理器配置
                .and().exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)//处理未授权
                .authenticationEntryPoint(restAuthenticationEntryPoint)//处理未认证
                .and().csrf().disable();
--return http.build();                
```