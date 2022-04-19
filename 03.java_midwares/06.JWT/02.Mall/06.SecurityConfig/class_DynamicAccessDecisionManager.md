#1.DynamicAccessDecisionManager

```java
/**
 * 动态权限决策管理器，用于判断用户是否有访问权限
 * Created by macro on 2020/2/7.
 */
public class DynamicAccessDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object object,
                       Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

}

```

#2.DynamicAccessDecisionManager.decide

```
decide
--Iterator<ConfigAttribute> iterator = configAttributes.iterator();
--while (iterator.hasNext())
----ConfigAttribute configAttribute = iterator.next();
----//将访问所需资源或用户拥有资源进行比对
----String needAuthority = configAttribute.getAttribute();
----for (GrantedAuthority grantedAuthority : authentication.getAuthorities())
------if (needAuthority.trim().equals(grantedAuthority.getAuthority()))
--------return
--throw new AccessDeniedException("抱歉，您没有访问权限");
```

#3.caller of decide

```
AbstractSecurityInterceptor.beforeInvocation
```