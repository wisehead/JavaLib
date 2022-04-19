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