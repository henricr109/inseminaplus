package com.inseminaplus.spring.security.mongodb.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inseminaplus.spring.security.mongodb.models.Order;
import com.inseminaplus.spring.security.mongodb.repository.OrderRepository;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders(@RequestParam(required = false) String id) {
        try {
            List<Order> orders = new ArrayList<>();

            if (id == null)
                orderRepository.findAll().forEach(orders::add);
            else
                orders.addAll(orderRepository.findByIdContaining(id));

            if (orders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") String id) {
        Optional<Order> orderData = orderRepository.findById(id);

        if (orderData.isPresent()) {
            return new ResponseEntity<>(orderData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        try {
            Order _order = orderRepository
                    .save(new Order(order.getDate(), order.getSituation(), order.getValue(), order.getClient()));
            return new ResponseEntity<>(_order, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") String id, @RequestBody Order order) {
        Optional<Order> orderData = orderRepository.findById(id);

        if (orderData.isPresent()) {
            Order _order = orderData.get();
            _order.setDate(order.getDate());
            _order.setClient(order.getClient());
            _order.setSituation(order.getSituation());
            _order.setValue(order.getValue());
            return new ResponseEntity<>(orderRepository.save(_order), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("id") String id) {
        try {
            orderRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/orders")
    public ResponseEntity<HttpStatus> deleteAllOrders() {
        try {
            orderRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/testing")
    public String endpointTests() {
        return "Endpoint functionals";
    }

}
