#1.generateToken

```
caller: UmsAdminServiceImpl::login

generateToken
--Map<String, Object> claims = new HashMap<>();
  //private static final String CLAIM_KEY_USERNAME = "sub";
  //private static final String CLAIM_KEY_CREATED = "created";
--claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
--claims.put(CLAIM_KEY_CREATED, new Date());
--generateToken(claims);
----return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
```

#2.config

```java
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
```

#3.application.xml

```
jwt:
  tokenHeader: Authorization #JWT存储的请求头
  secret: mall-admin-secret #JWT加解密使用的密钥
  expiration: 604800 #JWT的超期限时间(60*60*24*7)
  tokenHead: 'Bearer '  #JWT负载中拿到开头
```