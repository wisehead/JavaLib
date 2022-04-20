#1.login

```
login
--Map<String, String> params = new HashMap<>();                    
--params.put("client_id", AuthConstant.ADMIN_CLIENT_ID);           
--params.put("client_secret","123456");                            
--params.put("grant_type","password");                             
--params.put("username",username);                                 
--params.put("password",password);                                 
--CommonResult restResult = authService.getAccessToken(params);    

```