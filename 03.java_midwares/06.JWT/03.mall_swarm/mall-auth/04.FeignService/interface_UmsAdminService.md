#1. interface UmsAdminService

```
/**
 * Created by macro on 2019/10/18.
 */
@FeignClient("mall-admin")
public interface UmsAdminService {

    @GetMapping("/admin/loadByUsername")
    UserDto loadUserByUsername(@RequestParam String username);
}

```