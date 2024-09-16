package com.ssvHomeProducts.demo.controller;

import com.ssvHomeProducts.demo.entity.Item;
import com.ssvHomeProducts.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
  OrderService orderService;



    @GetMapping("/items")
    public List<Item> getAvailableItems() {
        return orderService.getAvailableItems();
    }
}
