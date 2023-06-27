package com.cybersoft.cozastore_java21.Service;

import com.cybersoft.cozastore_java21.Service.Imp.UserServiceImp;
import com.cybersoft.cozastore_java21.entity.UserEntity;
import com.cybersoft.cozastore_java21.exception.CustomException;
import com.cybersoft.cozastore_java21.payload.request.SignupRequest;
import com.cybersoft.cozastore_java21.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceImp {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean addUser(SignupRequest signupRequest) {
        boolean isSuccess = false;
        try {
            UserEntity user = new UserEntity();
            user.setUsername(signupRequest.getUsername());
            user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
            user.setEmail(signupRequest.getEmail());

            userRepository.save(user);
            isSuccess = true;
        }catch (Exception e){
            throw new CustomException("Lỗi thêm user" + e.getMessage());
        }
        return isSuccess;
    }
}
