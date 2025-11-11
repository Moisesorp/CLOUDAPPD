package co.edu.poli.cloudapp.restcontrollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.cloudapp.security.JwtUtil;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/auth")

public class AuthController {

    private JwtUtil jwutil;

public AuthController(JwtUtil jwutil) {
    this.jwutil = jwutil;   
}

@PostMapping("/token")
public ResponseEntity <Map<String, String>> token(@RequestBody Map<String, String> body) {
    String username = body.getOrDefault("username", "testuser");
    String token = jwutil.generateToken(username);
    return ResponseEntity.ok(Map.of("token", token));

    
    
}






}



