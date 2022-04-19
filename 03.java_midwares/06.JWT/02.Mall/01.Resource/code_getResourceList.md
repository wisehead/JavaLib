#1.getResourceList

```
UmsAdminServiceImpl::getResourceList
--adminCacheService.getResourceList(adminId);
----String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
----return (List<UmsResource>) redisService.get(key);
```


#2.config

```
    @Value("${redis.database}")
    private String REDIS_DATABASE;
    
    @Value("${redis.key.resourceList}")
    private String REDIS_KEY_RESOURCE_LIST;  
      
```


#3.application.xml
```
redis:
  database: mall
  key:
    admin: 'ums:admin'
    resourceList: 'ums:resourceList'
  expire:
    common: 86400 # 24小时
```