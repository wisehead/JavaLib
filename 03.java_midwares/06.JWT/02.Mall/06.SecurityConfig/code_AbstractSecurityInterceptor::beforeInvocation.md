#1.AbstractSecurityInterceptor::beforeInvocation

```
beforeInvocation
--Collection<ConfigAttribute> attributes = this.obtainSecurityMetadataSource().getAttributes(object);
----DynamicSecurityFilter.obtainSecurityMetadataSource
------DynamicSecurityMetadataSource.getAttributes
--------url = ((FilterInvocation) o).getRequestUrl()
--------path = URLUtil.getPath(url);
--------PathMatcher pathMatcher = new AntPathMatcher();
--------Iterator<String> iterator = configAttributeMap.keySet().iterator();
--------//获取访问该路径所需资源
--------while (iterator.hasNext())
----------String pattern = iterator.next();
----------if (pathMatcher.match(pattern, path))
------------configAttributes.add(configAttributeMap.get(pattern));
--------return configAttributes;
--Authentication authenticated = authenticateIfRequired();
----if (authentication.isAuthenticated() && !alwaysReauthenticate)
------return authentication;
----authentication = authenticationManager.authenticate(authentication);
----SecurityContextHolder.getContext().setAuthentication(authentication);
----return authentication;
--this.accessDecisionManager.decide(authenticated, object, attributes);
----DynamicAccessDecisionManager.decide
```