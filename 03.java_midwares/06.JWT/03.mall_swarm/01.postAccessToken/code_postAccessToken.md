#1.postAccessToken

```java
    @ApiImplicitParams({
            @ApiImplicitParam(name = "grant_type", value = "授权模式", required = true),
            @ApiImplicitParam(name = "client_id", value = "Oauth2客户端ID", required = true),
            @ApiImplicitParam(name = "client_secret", value = "Oauth2客户端秘钥", required = true),
            @ApiImplicitParam(name = "refresh_token", value = "刷新token"),
            @ApiImplicitParam(name = "username", value = "登录用户名"),
            @ApiImplicitParam(name = "password", value = "登录密码")
    })
@RequestMapping(value = "/oauth/token", method = RequestMethod.POST)    
postAccessToken
--OAuth2AccessToken oAuth2AccessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();
----TokenEndpoint.postAccessToken
------TokenRequest tokenRequest = getOAuth2RequestFactory().createTokenRequest(parameters, authenticatedClient);
------if (!StringUtils.hasText(tokenRequest.getGrantType())) {
--------throw new InvalidRequestException("Missing grant type");
------if (tokenRequest.getGrantType().equals("implicit")) {
--------throw new InvalidGrantException("Implicit grant type not supported from token endpoint");
------OAuth2AccessToken token = getTokenGranter().grant(tokenRequest.getGrantType(), tokenRequest);
--Oauth2TokenDto oauth2TokenDto = Oauth2TokenDto.builder()
                .token(oAuth2AccessToken.getValue())
                .refreshToken(oAuth2AccessToken.getRefreshToken().getValue())
                .expiresIn(oAuth2AccessToken.getExpiresIn())
                .tokenHead(AuthConstant.JWT_TOKEN_PREFIX).build();
--                	
```

#2.caller

```
login
--params.put("client_id", AuthConstant.ADMIN_CLIENT_ID);//String ADMIN_CLIENT_ID = "admin-app";           
--params.put("client_secret","123456");                            
--params.put("grant_type","password");                             
--params.put("username",username);                                 
--params.put("password",password);       
```