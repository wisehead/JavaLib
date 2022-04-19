#1.UserDetailsServiceImpl

```java
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    //public static final String SERVICE_NAME = "com.braive.backend.service.user.UserDetailsServiceImpl";
    @Autowired
    private IUserMapper iUserMapper;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        username = username.trim();
        User user = iUserMapper.loadUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("userName not exist");
        }
        return user;
    }
}
```