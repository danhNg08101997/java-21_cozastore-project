package com.cybersoft.cozastore_java21.controller;

import com.cybersoft.cozastore_java21.Service.Imp.CategoryServiceImp;
import com.cybersoft.cozastore_java21.payload.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryServiceImp categoryServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getAllCategories(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setData(categoryServiceImp.getAllCategories());

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
