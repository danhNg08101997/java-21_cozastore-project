package com.cybersoft.cozastore_java21.controller;

import com.cybersoft.cozastore_java21.Service.Imp.UserServiceImp;
import com.cybersoft.cozastore_java21.payload.request.SignupRequest;
import com.cybersoft.cozastore_java21.payload.response.BaseResponse;
import com.cybersoft.cozastore_java21.utils.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private UserServiceImp userServiceImp;

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<?> signin(
            @RequestParam String email,
            @RequestParam String password
    ){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, password);
        authenticationManager.authenticate(token);
        // Nếu chứng thực thành công sẽ chạy code tiếp theo còn nếu thất bại sẽ trả ra lỗi chưa chứng thực
        String jwt = jwtHelper.generateToken(email);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(jwt);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<?> signup(@Valid SignupRequest signupRequest){

boolean isSuccess = userServiceImp.addUser(signupRequest);

        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(isSuccess);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
