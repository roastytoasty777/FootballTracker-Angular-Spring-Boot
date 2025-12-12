package com.example.isitcom.FootballTracker.controlleur;

import com.example.isitcom.FootballTracker.controlleur.AuthRequest;
import com.example.isitcom.FootballTracker.controlleur.AuthResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthRestController {

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {

        System.out.println("➡ Tentative de login : " +
                request.getUsername() + " / " + request.getPassword());


        if ("admin".equals(request.getUsername())
                && "admin".equals(request.getPassword())) {

            String fakeToken = "dummy-token";
            System.out.println("✅ Auth OK, on renvoie le token");
            return ResponseEntity.ok(new AuthResponse(fakeToken));
        }

        System.out.println("⛔ Auth KO, mauvais identifiants");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}