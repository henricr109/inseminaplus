package com.inseminaplus.spring.security.mongodb.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.inseminaplus.spring.security.mongodb.exception.ResourceNotFoundException;
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

import com.inseminaplus.spring.security.mongodb.models.Item;
import com.inseminaplus.spring.security.mongodb.repository.ItemRepository;
import com.inseminaplus.spring.security.mongodb.repository.OrderRepository;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems(@RequestParam(required = false) String name) {
        try {
            List<Item> items = new ArrayList<Item>();

            if (name == null)
                itemRepository.findAll().forEach(items::add);
            else
                itemRepository.findByNameContaining(name).forEach(items::add);

            if (items.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable("id") long id) {
        Optional<Item> itemData = itemRepository.findById(id);

        if (itemData.isPresent()) {
            return new ResponseEntity<>(itemData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/orders/{orderId}/items")
    public ResponseEntity<Item> createItem(@PathVariable(value = "orderId") Long orderId,
                                                 @RequestBody Item itemRequest) {
        Item item = orderRepository.findById(String.valueOf(orderId)).map(order -> {
            itemRequest.setOrder(order);
            return itemRepository.save(itemRequest);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found Order with id = " + orderId));

        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }


    @PutMapping("/items/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable("id") Long id, @RequestBody Item item) {
        Optional<Item> itemData = itemRepository.findById(id);

        if (itemData.isPresent()) {
            Item _item = itemData.get();
            _item.setName(item.getName());
            _item.setValue(item.getValue());
            return new ResponseEntity<>(itemRepository.save(_item), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<HttpStatus> deleteItem(@PathVariable("id") Long id) {
        try {
            itemRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/items")
    public ResponseEntity<HttpStatus> deleteAllItems() {
        try {
            itemRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}