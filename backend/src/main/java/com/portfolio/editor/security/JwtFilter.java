package com.portfolio.editor.security;

import jakarta.servlet.*; import jakarta.servlet.http.*; import org.springframework.security.authentication.UsernamePasswordAuthenticationToken; import org.springframework.security.core.authority.SimpleGrantedAuthority; import org.springframework.security.core.context.SecurityContextHolder; import org.springframework.stereotype.Component; import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException; import java.util.List;

@Component public class JwtFilter extends OncePerRequestFilter {
  private final JwtService jwt; public JwtFilter(JwtService jwt){this.jwt=jwt;}
  @Override protected void doFilterInternal(HttpServletRequest req,HttpServletResponse res,FilterChain chain)throws ServletException,IOException{
    String h=req.getHeader("Authorization");
    if(h!=null && h.startsWith("Bearer ")){String token=h.substring(7); try{String email=jwt.extract(token); if(jwt.valid(token,email)) SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(email,null,List.of(new SimpleGrantedAuthority("ROLE_ADMIN"))));}catch(Exception ignored){}}
    chain.doFilter(req,res);
  }
}
