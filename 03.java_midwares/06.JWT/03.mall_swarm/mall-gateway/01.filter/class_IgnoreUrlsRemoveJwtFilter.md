#1.IgnoreUrlsRemoveJwtFilter

```
filter
--ServerHttpRequest request = exchange.getRequest();
--URI uri = request.getURI();
--PathMatcher pathMatcher = new AntPathMatcher();
--//白名单路径移除JWT请求头
--List<String> ignoreUrls = ignoreUrlsConfig.getUrls();
--for (String ignoreUrl : ignoreUrls)
----if (pathMatcher.match(ignoreUrl, uri.getPath())) 
------request = exchange.getRequest().mutate().header(AuthConstant.JWT_TOKEN_HEADER, "").build();
------exchange = exchange.mutate().request(request).build();
------return chain.filter(exchange);
--return chain.filter(exchange);
```