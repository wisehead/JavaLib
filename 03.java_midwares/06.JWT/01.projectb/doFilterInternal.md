#1.doFilterInternal

```
doFilterInternal
--token = request.getHeader(Constants.JWT.TOKEN_HEADER);
--
```

#2.JWT config

```
  JWT:
    tokenHeader : Authorization
    tokenHead : Bearer
    tokenSecurityKey : xxxxxxxx
    tokenIssuer : xxx.com
    tokenExpireSeconds: 86400
    tokenCacheExpireSeconds: 1800
    tokenRefreshExpireSeconds: 30
    tokenAudience : xxx.com
    tokenMobileAudience : m.xxx.com
    tokenLatestTime: latestTime
    tokenLatestIP: latestIP
```