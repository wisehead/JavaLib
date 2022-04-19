#1.class DynamicSecurityFilter

```java
/**
 * 动态权限过滤器，用于实现基于路径的动态权限过滤
 * Created by macro on 2020/2/7.
 */
public class DynamicSecurityFilter extends AbstractSecurityInterceptor implements Filter {

    @Autowired
    private DynamicSecurityMetadataSource dynamicSecurityMetadataSource;
    @Autowired
    private IgnoreUrlsConfig ignoreUrlsConfig;

    @Autowired
    public void setMyAccessDecisionManager(DynamicAccessDecisionManager dynamicAccessDecisionManager) {
        super.setAccessDecisionManager(dynamicAccessDecisionManager);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return dynamicSecurityMetadataSource;
    }

}
```

#2. doFilter

```
doFilter
--HttpServletRequest request = (HttpServletRequest) servletRequest;
--FilterInvocation fi = new FilterInvocation(servletRequest, servletResponse, filterChain);
--//OPTIONS请求直接放行
--if(request.getMethod().equals(HttpMethod.OPTIONS.toString()))
----fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
----return;
--//白名单请求直接放行
--PathMatcher pathMatcher = new AntPathMatcher();
--for (String path : ignoreUrlsConfig.getUrls()) {
            if(pathMatcher.match(path,request.getRequestURI())){
                fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
                return;
            }
        }
--//此处会调用AccessDecisionManager中的decide方法进行鉴权操作
--InterceptorStatusToken token = super.beforeInvocation(fi);
--fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
--super.afterInvocation(token, null);
```