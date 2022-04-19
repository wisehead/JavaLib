#1.doFilterInternal

```
doFilterInternal
--token = request.getHeader(Constants.JWT.TOKEN_HEADER);
--if (token != null && token.startsWith(Constants.JWT.TOKEN_HEAD))
----token = token.replace(Constants.JWT.TOKEN_HEAD, "").trim();
----boolean isWhiteList = request.getRequestURL().toString().endsWith(TOKEN_BALCK_LIST);
----username = jwtTokenUtil.getUsernameFromToken(token);
------Claims claims = getClaimsFromToken(token);
------username = claims.getSubject();
----if (username != null && SecurityContextHolder.getContext().getAuthentication() == null)
------User user = (User) userDetailsService.loadUserByUsername(username);
------if (jwtTokenUtil.validateToken(token, user, isWhiteList)) 
--------UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
--------authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
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
