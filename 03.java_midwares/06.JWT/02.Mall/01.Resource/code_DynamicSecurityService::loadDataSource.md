#1. loadDataSource

```
DynamicSecurityService::loadDataSource
--resourceList = resourceService.listAll();
----UmsResourceServiceImpl.listAll()
------resourceMapper.selectByExample(new UmsResourceExample());
```

#2.caller

```
DynamicSecurityMetadataSource.loadDataSource
--configAttributeMap = dynamicSecurityService.loadDataSource();
```

#3.DynamicSecurityMetadataSource.getAttributes
deep caller

```java
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        if (configAttributeMap == null) this.loadDataSource();
        List<ConfigAttribute>  configAttributes = new ArrayList<>();
        //获取当前访问的路径
        String url = ((FilterInvocation) o).getRequestUrl();
        String path = URLUtil.getPath(url);
        PathMatcher pathMatcher = new AntPathMatcher();
        Iterator<String> iterator = configAttributeMap.keySet().iterator();
        //获取访问该路径所需资源
        while (iterator.hasNext()) {
            String pattern = iterator.next();
            if (pathMatcher.match(pattern, path)) {
                configAttributes.add(configAttributeMap.get(pattern));
            }
        }
        // 未设置操作请求权限，返回空集合
        return configAttributes;
    }
```

#4.caller of DynamicSecurityMetadataSource.getAttributes

```
AbstractSecurityInterceptor
```