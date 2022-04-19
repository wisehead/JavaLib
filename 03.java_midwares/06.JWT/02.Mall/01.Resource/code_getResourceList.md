#1.getResourceList

```
UmsAdminServiceImpl::getResourceList
--adminCacheService.getResourceList(adminId);
----String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
----return (List<UmsResource>) redisService.get(key);
--adminRoleRelationDao.getResourceList(adminId);
----mybatis.getResourceList
--adminCacheService.setResourceList(adminId,resourceList);
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

#4. adminRoleRelationDao.getResourceList

```
--mall-admin/src/main/resources/dao/UmsAdminRoleRelationDao.xml

    <select id="getResourceList" resultType="com.macro.mall.model.UmsResource">
        SELECT
            ur.id id,
            ur.create_time createTime,
            ur.`name` `name`,
            ur.url url,
            ur.description description,
            ur.category_id categoryId
        FROM
            ums_admin_role_relation ar
        LEFT JOIN ums_role r ON ar.role_id = r.id
        LEFT JOIN ums_role_resource_relation rrr ON r.id = rrr.role_id
        LEFT JOIN ums_resource ur ON ur.id = rrr.resource_id
        WHERE
            ar.admin_id = #{adminId}
        AND ur.id IS NOT NULL
        GROUP BY
            ur.id
    </select>
```