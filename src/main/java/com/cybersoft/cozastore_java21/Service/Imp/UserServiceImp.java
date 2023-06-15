package com.cybersoft.cozastore_java21.Service.Imp;

import com.cybersoft.cozastore_java21.payload.request.SignupRequest;

public interface UserServiceImp {
    boolean addUser(SignupRequest signupRequest);
}
