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
--UmsAdminLoginLog loginLog = new UmsAdminLoginLog();
--loginLog.setAdminId(admin.getId());
--loginLog.setCreateTime(new Date());
--ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
--HttpServletRequest request = attributes.getRequest();
--loginLog.setIp(RequestUtil.getRequestIp(request));
--loginLogMapper.insert(loginLog);
--
```

#3.mybatis mapper
mall-mbg/src/main/resources/com/macro/mall/mapper/UmsAdminLoginLogMapper.xml
```
  <insert id="insert" parameterType="com.macro.mall.model.UmsAdminLoginLog">
    <selectKey keyProperty="id" order="AFTER" resultType="java.lang.Long">
      SELECT LAST_INSERT_ID()
    </selectKey>
    insert into ums_admin_login_log (admin_id, create_time, ip, 
      address, user_agent)
    values (#{adminId,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, #{ip,jdbcType=VARCHAR}, 
      #{address,jdbcType=VARCHAR}, #{userAgent,jdbcType=VARCHAR})
  </insert>
```