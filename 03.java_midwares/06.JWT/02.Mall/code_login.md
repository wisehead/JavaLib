#1.login(mall-admin)

```
login
--UserDetails userDetails = loadUserByUsername(username);
----UmsAdmin admin = getAdminByUsername(username);
----List<UmsResource> resourceList = getResourceList(admin.getId());
```