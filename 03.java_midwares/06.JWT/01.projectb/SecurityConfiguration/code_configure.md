#1.configure

```java
protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .antMatchers("/test/helloNoSign").permitAll()
                .antMatchers("/api/segment/**","/api/segment/track").permitAll()
                .antMatchers("/api/xxx/**").access("hasAuthority('xxx')")
                .anyRequest().authenticated();
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler).authenticationEntryPoint(unauthorizedHandler);
        http.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);
        http.headers().cacheControl();
    }
```