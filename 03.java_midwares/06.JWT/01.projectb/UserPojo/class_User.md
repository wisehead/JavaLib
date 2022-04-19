#1.class User

```
public class User extends Users implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        //for (Role role : roles) {
        //authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        //}
        if(this.getRole().equals(UsersRole.THERAPIST.getValue())){
            authorities.add(new SimpleGrantedAuthority("CLINICIAN"));
        }else{
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return authorities;
    }
}
```