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