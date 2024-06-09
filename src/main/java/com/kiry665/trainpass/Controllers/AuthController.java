package com.kiry665.trainpass.Controllers;

import com.kiry665.trainpass.Models.Role;
import com.kiry665.trainpass.ModelsRequest.AuthenticationResponse;
import com.kiry665.trainpass.Security.JwtUtil;
import com.kiry665.trainpass.ModelsRequest.AuthenticationRequest;
import com.kiry665.trainpass.Models.User;
import com.kiry665.trainpass.Services.RoleService;
import com.kiry665.trainpass.Services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Value("${jwt.expiration}")
    private Long jwtExpiration;

    @Value("${jwt.longexpiration}")
    private Long jwtLongExpiration;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthenticationRequest authenticationRequest) {
        if (userService.findByUsername(authenticationRequest.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username is already in use");
        }

        Role role = roleService.getRoleByName("USER");
        User user = new User(authenticationRequest.getUsername(), authenticationRequest.getPassword(), role);
        userService.saveUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = authenticationRequest.getRemember() ? jwtUtil.generateLongTimeToken(userDetails.getUsername()) : jwtUtil.generateToken(userDetails.getUsername());

        return ResponseEntity.ok(new AuthenticationResponse(jwt, authenticationRequest.getRemember() ? jwtLongExpiration : jwtExpiration));
    }
}
