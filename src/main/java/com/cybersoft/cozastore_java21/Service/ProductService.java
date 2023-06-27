package com.cybersoft.cozastore_java21.Service;

import com.cybersoft.cozastore_java21.Service.Imp.ProductSerivceImp;
import com.cybersoft.cozastore_java21.entity.ProductEntity;
import com.cybersoft.cozastore_java21.payload.response.ProductResponse;
import com.cybersoft.cozastore_java21.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ProductSerivceImp {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<ProductResponse> getProductByCategoryId(int id) {
        List<ProductEntity> list = productRepository.findByCategoryId(id);
        List<ProductResponse> responseList = new ArrayList<>();

        for (ProductEntity data: list) {
            ProductResponse response = new ProductResponse();
            response.setId(data.getId());
            response.setName(data.getName());
            response.setPrice(data.getPrice());
            response.setImage(data.getImage());

            responseList.add(response);
        }

        return responseList;
    }
}
