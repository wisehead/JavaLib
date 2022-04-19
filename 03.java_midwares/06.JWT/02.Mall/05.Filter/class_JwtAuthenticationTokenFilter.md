#1. doFilterInternal

```
doFilterInternal
--authHeader = request.getHeader(this.tokenHeader);
--if (authHeader != null && authHeader.startsWith(this.tokenHead))
----String authToken = authHeader.substring(this.tokenHead.length());
----String username = jwtTokenUtil.getUserNameFromToken(authToken);
----if (username != null && SecurityContextHolder.getContext().getAuthentication() == null)
------UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
------if (jwtTokenUtil.validateToken(authToken, userDetails))
--------UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
--------authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
--------SecurityContextHolder.getContext().setAuthentication(authentication)
```