package com.cybersoft.cozastore_java21.controller;

import com.cybersoft.cozastore_java21.Service.Imp.ProductSerivceImp;
import com.cybersoft.cozastore_java21.payload.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductSerivceImp productSerivceImp;
    @GetMapping("/category/{id}")
    public ResponseEntity<?> getProductByCategory(@PathVariable int id){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setData(productSerivceImp.getProductByCategoryId(id));

        return new ResponseEntity<>(baseResponse,HttpStatus.OK);
    }
}
