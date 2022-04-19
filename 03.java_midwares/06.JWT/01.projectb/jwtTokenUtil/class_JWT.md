#1.class JWT 

```java
    public static class  JWT{
        /**
         * HTTP HEADER
         */
        public static String TOKEN_HEADER;
        /**
         * JWT token head
         */
        public static String TOKEN_HEAD;
        /**
         * JWT token security key
         */
        public static String TOKEN_SECURITY_KEY;
        /**
         * JWT token issuer
         */
        public static String TOKEN_ISSUER;
        /**
         * JWT token expire seconds
         */
        public static Long TOKEN_EXPIRE_SECONDS;

        /**
         * JWT refreshed token expire seconds
         */
        public static Long TOKEN_CACHE_EXPIRE_SECONDS;

        /**
         * JWT refreshed token expire seconds
         */
        public static Long TOKEN_REFRESH_EXPIRE_SECONDS;
        /**
         * JWT token audience
         */
        public static String TOKEN_AUDIENCE;
        /**
         * JWT token mobile audience
         */
        public static String TOKEN_MOBILE_AUDIENCE;
        /**
         * JWT token latest login time
         */
        public static String TOKEN_LAST_TIME_NAME;
        /**
         * JWT token latest login ip
         */
        public static String TOKEN_LAST_IP_NAME;

    }
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
