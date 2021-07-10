package com.geekbrains.spring.hw3.repositories;

import com.geekbrains.spring.hw3.model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepo {

    private List<Product> productList;

    public List<Product> getProductList() {
        return Collections.unmodifiableList(productList);
    }

    public Product getProduct(int index) {
        return productList.get(index);
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    public void updateProduct(Product product){
        int index = productList.indexOf(product);
        productList.set(index, product);
    }

    public void deleteProduct(Product product){
        productList.remove(product);
    }

    @PostConstruct
    public void init(){
        productList = new ArrayList<>();
        productList.add(new Product(1, "Apple", 25.9f));
        productList.add(new Product(2, "Orange", 36.9f));
        productList.add(new Product(3, "Banana", 45.5f));
        productList.add(new Product(4, "Peach", 38.7f));
        productList.add(new Product(5, "Cupcake", 20.0f));
        productList.add(new Product(6, "Donut", 12.6f));
    }
}
