package com.cybersoft.cozastore_java21.Service.Imp;

import com.cybersoft.cozastore_java21.payload.response.CategoryResponse;

import java.util.List;

public interface CategoryServiceImp {
    List<CategoryResponse> getAllCategories();
}
