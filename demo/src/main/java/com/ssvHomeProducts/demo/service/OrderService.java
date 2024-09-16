package com.ssvHomeProducts.demo.service;

import com.ssvHomeProducts.demo.entity.Item;
import com.ssvHomeProducts.demo.entity.Order;
import com.ssvHomeProducts.demo.entity.OrderDetail;
import com.ssvHomeProducts.demo.repository.ItemRepository;
import com.ssvHomeProducts.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
@Autowired
 ItemRepository itemRepository;
@Autowired
 OrderRepository orderRepository;


    public Order createOrder(int userId, List<OrderDetail> orderDetails) {
        double totalPrice = orderDetails.stream()
                .mapToDouble(detail -> detail.getQuantity() * detail.getItemPrice())
                .sum();

        Order order = new Order();
        order.setUserId(userId);
        order.setTotalPrice(totalPrice);
        order.setOrderDetails(orderDetails);
        orderDetails.get(0).setOrder(order);
      return   orderRepository.save(order);

    }

    public List<Item> getAvailableItems() {
        return itemRepository.findAll();
    }
}
