package com.portfolio.editor.controller;
import com.portfolio.editor.dto.*; import com.portfolio.editor.security.JwtService; import org.springframework.beans.factory.annotation.Value; import org.springframework.http.*; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/auth") public class AuthController {
 private final JwtService jwt; private final String email,password;
 public AuthController(JwtService jwt,@Value("${app.admin.email}")String email,@Value("${app.admin.password}")String password){this.jwt=jwt;this.email=email;this.password=password;}
 @PostMapping("/login") public ResponseEntity<?> login(@RequestBody LoginRequest r){if(email.equals(r.email())&&password.equals(r.password()))return ResponseEntity.ok(new LoginResponse(jwt.generate(email)));return ResponseEntity.status(401).body("Invalid credentials");}
}
