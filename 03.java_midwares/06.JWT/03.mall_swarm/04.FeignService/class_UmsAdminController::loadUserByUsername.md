#1.UmsAdminController::loadUserByUsername

```
loadUserByUsername
--adminService.loadUserByUsername(username);
----UmsAdminServiceImpl::loadUserByUsername
------UmsAdmin admin = getAdminByUsername(username);
------List<UmsRole> roleList = getRoleList(admin.getId());
--------adminRoleRelationDao.getRoleList(adminId);
----------mybatis.sql
------List<String> roleStrList = roleList.stream().map(item -> item.getId() + "_" + item.getName()).collect(Collectors.toList());
------userDTO.setRoles(roleStrList);
------return userDTO;
```

#2.mybatis

mall-admin/src/main/resources/dao/UmsAdminRoleRelationDao.xml
```
    <select id="getRoleList" resultMap="com.macro.mall.mapper.UmsRoleMapper.BaseResultMap">
        select r.*
        from ums_admin_role_relation ar left join ums_role r on ar.role_id = r.id
        where ar.admin_id = #{adminId}
    </select>
```