package com.portfolio.editor.config;
import com.portfolio.editor.security.JwtFilter; import org.springframework.context.annotation.*; import org.springframework.security.config.annotation.web.builders.HttpSecurity; import org.springframework.security.config.http.SessionCreationPolicy; import org.springframework.security.web.*; import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter; import org.springframework.web.cors.*; import java.util.List;
@Configuration
@org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
public class SecurityConfig {
  @Bean SecurityFilterChain filterChain(HttpSecurity http,JwtFilter jwt)throws Exception{
    http.csrf(c->c.disable()).cors(c->c.configurationSource(cors())).sessionManagement(s->s.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).authorizeHttpRequests(a->a.requestMatchers("/api/auth/**","/api/videos","/api/videos/**","/assets/**","/","/index.html").permitAll().anyRequest().hasRole("ADMIN")).addFilterBefore(jwt,UsernamePasswordAuthenticationFilter.class); return http.build();
  }
  @Bean CorsConfigurationSource cors(){CorsConfiguration c=new CorsConfiguration();c.setAllowedOriginPatterns(List.of("*"));c.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));c.setAllowedHeaders(List.of("*"));c.setAllowCredentials(false);UrlBasedCorsConfigurationSource s=new UrlBasedCorsConfigurationSource();s.registerCorsConfiguration("/**",c);return s;}
}
