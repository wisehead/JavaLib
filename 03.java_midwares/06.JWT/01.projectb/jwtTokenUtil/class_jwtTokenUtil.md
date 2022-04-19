#1.getUsernameFromToken

```
getUsernameFromToken
--Claims claims = getClaimsFromToken(token);
--username = claims.getSubject();
```

#2.getClaimsFromToken
```
getClaimsFromToken
--claims = Jwts.parser()
			.setSigningKey(Constants.JWT.TOKEN_SECURITY_KEY)
          .parseClaimsJws(token)
          .getBody();
```

#3.getCreatedDateFromToken
```
getCreatedDateFromToken
--Claims claims = getClaimsFromToken(token);
--created =  claims.getIssuedAt();
```


#4.validateToken

```
validateToken
--tokenCache = redisUtils.get(REDIS_TOKEN_NORMAL_KEY+user.getId().toString());
--tokenRefreshedCache = redisUtils.get(REDIS_TOKEN_REFRESHED_KEY+user.getId().toString());
--if((StringUtils.isEmpty(tokenCache) && !tokenCache.equals(token))
         ||(StringUtils.isEmpty(tokenRefreshedCache) && !tokenCache.equals(token)))
----return false;
--username = getUsernameFromToken(token);
--created = getCreatedDateFromToken(token);
```