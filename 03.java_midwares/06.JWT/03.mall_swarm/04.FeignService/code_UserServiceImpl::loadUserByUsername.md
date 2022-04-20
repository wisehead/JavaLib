#1.loadUserByUsername

```
loadUserByUsername
--//request中要带有client_id字段
--String clientId = request.getParameter("client_id");
--if(AuthConstant.ADMIN_CLIENT_ID.equals(clientId)){
----userDto = adminService.loadUserByUsername(username);
--else
----userDto = memberService.loadUserByUsername(username);
--userDto.setClientId(clientId);
        
```