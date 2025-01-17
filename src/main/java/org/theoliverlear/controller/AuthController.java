package org.theoliverlear.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.theoliverlear.communication.request.AuthRequest;
import org.theoliverlear.communication.response.AuthResponse;
import org.theoliverlear.communication.response.LogoutResponse;
import org.theoliverlear.service.AuthService;

@Controller
@RequestMapping("/authorize")
public class AuthController {
    private AuthService authService;
    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @RequestMapping("/")
    public String auth() {
        return "authorize";
    }
    @RequestMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody AuthRequest authRequest, HttpSession session) {
        boolean isAuthorized = this.authService.signup(authRequest, session);
        HttpStatus status = isAuthorized ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(new AuthResponse(isAuthorized), status);
    }
    @RequestMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest, HttpSession session) {
        boolean isAuthorized = this.authService.login(authRequest, session);
        HttpStatus status = isAuthorized ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return new ResponseEntity<>(new AuthResponse(isAuthorized), status);
    }
    @RequestMapping("/logout")
    public ResponseEntity<LogoutResponse> logout(HttpSession session) {
        boolean isLoggedOut = this.authService.logout(session);
        HttpStatus status = isLoggedOut ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(new LogoutResponse(isLoggedOut), status);
    }
    @RequestMapping("/isloggedin")
    public ResponseEntity<AuthResponse> isLoggedIn(HttpSession session) {
        boolean isLoggedIn = this.authService.isLoggedIn(session);
        HttpStatus status = isLoggedIn ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return new ResponseEntity<>(new AuthResponse(isLoggedIn), status);
    }
}
