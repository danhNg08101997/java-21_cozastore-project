package com.cybersoft.cozastore_java21.Service.Imp;

import com.cybersoft.cozastore_java21.payload.response.ProductResponse;

import java.util.List;

public interface ProductSerivceImp {
    List<ProductResponse>getProductByCategoryId(int id);
}
