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
--Boolean isTokenValid =  (username.equals(user.getUsername())
                && !isTokenExpired(token)
                && !isCreatedBeforeLastPasswordReset(created, user.getLastPasswordResetDate()));
----isTokenExpired
------expiration = getExpirationDateFromToken(token);
------return expiration.before(new Date());
----isCreatedBeforeLastPasswordReset
------return (lastPasswordReset != null && created.before(lastPasswordReset));
--if(isTokenValid && !noneExpireExtend)
----redisUtils.set(REDIS_TOKEN_NORMAL_KEY + user.getId().toString(), token, Constants.JWT.TOKEN_CACHE_EXPIRE_SECONDS);
```

#5.generateToken

```java
generateToken
--Map<String, Object> claims = new HashMap<>();
--claims.put(Constants.JWT.TOKEN_LAST_IP_NAME, user.getCurrentSignInIp());
--claims.put(Constants.JWT.TOKEN_LAST_TIME_NAME, user.getCurrentSignInAt());
--token = generateToken(user.getId(),user.getUsername(),claims);
----token = Jwts.builder()
                    .setClaims(claims)
                    .setNotBefore(new Date())
                    .setIssuedAt(new Date())
                    .setId(userId.toString())
                    .setSubject(userEmail)
                    .setAudience(Constants.JWT.TOKEN_AUDIENCE)
                    .setIssuer(Constants.JWT.TOKEN_ISSUER)
                    .setExpiration(generateExpirationDate())
                    .signWith(SignatureAlgorithm.HS512, Constants.JWT.TOKEN_SECURITY_KEY)
                    .compact();
                    
--redisUtils.set(REDIS_TOKEN_NORMAL_KEY + user.getId().toString(),token,Constants.JWT.TOKEN_CACHE_EXPIRE_SECONDS);
```