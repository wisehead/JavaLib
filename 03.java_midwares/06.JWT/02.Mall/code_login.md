#1.login(mall-admin)

```
login
--UserDetails userDetails = loadUserByUsername(username);
----UmsAdmin admin = getAdminByUsername(username);
----List<UmsResource> resourceList = getResourceList(admin.getId());
--UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
--SecurityContextHolder.getContext().setAuthentication(authentication);
--token = jwtTokenUtil.generateToken(userDetails);
--insertLoginLog(username);
```

#2.insertLoginLog

```
insertLoginLog
--admin = getAdminByUsername(username);
```