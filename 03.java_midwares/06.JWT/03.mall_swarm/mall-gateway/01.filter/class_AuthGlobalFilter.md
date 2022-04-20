#1.class AuthGlobalFilter

```java
AuthGlobalFilter.filter
--String token = exchange.getRequest().getHeaders().getFirst(AuthConstant.JWT_TOKEN_HEADER);
--String realToken = token.replace(AuthConstant.JWT_TOKEN_PREFIX, "");
--JWSObject jwsObject = JWSObject.parse(realToken);
--String userStr = jwsObject.getPayload().toString();
--ServerHttpRequest request = exchange.getRequest().mutate().header(AuthConstant.USER_TOKEN_HEADER, userStr).build();
--exchange = exchange.mutate().request(request).build();

```