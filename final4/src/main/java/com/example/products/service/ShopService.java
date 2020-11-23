package com.example.products.service;

import com.example.products.model.Login;
import com.example.products.model.Shop;
import com.example.products.repository.LoginRepository;
import com.example.products.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {
    private final ShopRepository shopRepository;
    private final LoginRepository loginRepository;

    public ShopService(ShopRepository shopRepository, LoginRepository loginRepository) {
        this.shopRepository = shopRepository;
        this.loginRepository = loginRepository;
    }

    public Shop getCustomerByToken(String token) {
        Login login = loginRepository.findByToken(token);
        return shopRepository.findById(login.getShop_id());

    }

    public Iterable<Shop> getAll(){
        return shopRepository.findAll();
    }

    public Optional<Shop> getCustomerById(Long shop_id) {
        return shopRepository.findById(shop_id);
    }

//    public Iterable<Shop> getCustomersValue() {
//        List<Shop> customers = (List<Shop>) shopRepository.findAll();
//        List<OrderItem> orders = (List<Order>) orderRepository.findAll();
//        int n = customers.size();
//        int n2 = orders.size();
//        for (int i=0; i<n; i++){
//            customers.get(i).setPassword("");
//            int sum = 0;
//            for (int j=0; j<n2; j++){
//                if(customers.get(i).getId() == orders.get(j).getCustomerId()){
//                    sum += orders.get(j).getTotalPrice();
//                }
//            }
//            customers.get(i).setPassword(Integer.toString(sum));
//            if (sum == 0){
//                customers.remove(i);
//            }
//        };
//        return customers;
//    }

}