package com.study.study_server.controller;

import com.study.study_server.config.JwtTokenUtil;
import com.study.study_server.service.JwtUserDetailsService;
import com.study.study_server.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        final Member member = userDetailService.authenticateByNameAndPassword
                (authenticationRequest.getEmail(), authenticationRequest.getPassword());
        final String token = jwtTokenUtil.generateToken(member.getMemberName());
        return ResponseEntity.ok(new JwtResponse(token));
    }

}

@Data
class JwtRequest {

    private String email;
    private String password;

}

@Data
@AllArgsConstructor
class JwtResponse {

    private String token;

}
