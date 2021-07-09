package com.geekbrains.spring.hw3.services;

import com.geekbrains.spring.hw3.model.Product;
import com.geekbrains.spring.hw3.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepo productRepo;

    @Autowired
    public void setProductRepo(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public int getProductCount(){
        return productRepo.getProductList().size();
    }

    public float getAveragePrice(){
        if (getProductCount() == 0){
            return 0;
        }
        int avg = 0;
        for (Product product: productRepo.getProductList()){
            avg += product.getCost();
        }
        return avg /= getProductCount();
    }

    public List<Product> getProductList(){
        return productRepo.getProductList();
    }

}
