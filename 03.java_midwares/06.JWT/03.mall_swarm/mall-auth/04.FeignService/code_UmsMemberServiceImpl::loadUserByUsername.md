#1.loadUserByUsername

```
loadUserByUsername
--UmsMember member = getByUsername(username);
--BeanUtil.copyProperties(member,userDto);
--userDto.setRoles(CollUtil.toList("前台会员"));
--return userDto;
```