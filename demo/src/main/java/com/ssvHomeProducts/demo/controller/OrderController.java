package com.ssvHomeProducts.demo.controller;

import com.ssvHomeProducts.demo.entity.Order;
import com.ssvHomeProducts.demo.entity.OrderDetail;
import com.ssvHomeProducts.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:8080") // Adjust the front-end port as needed
public class OrderController {

    @Autowired
 OrderService orderService;


    @PostMapping("/create")
    public Order createOrder(@RequestBody List<OrderDetail> orderDetails, @RequestParam int userId) {
        return orderService.createOrder(userId, orderDetails);
    }
}
