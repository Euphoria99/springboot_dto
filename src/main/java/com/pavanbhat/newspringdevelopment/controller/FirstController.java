package com.pavanbhat.newspringdevelopment.controller;

import com.pavanbhat.newspringdevelopment.pojo.Order;
import com.pavanbhat.newspringdevelopment.record.OrderRecord;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

    @GetMapping("/hello")
    public String sayHello(){
        return "hello from my first controller!";
    }

    @PostMapping("/post")
    public String post(@RequestBody String name){
        return "Request Accepted " + name;
    }

    @PostMapping("/post-order")
    public String postOrder(@RequestBody Order order){
        return "Accepted order : " + order.toString();
    }

    @PostMapping("/post-order-record")
    public String postOrderRecord(@RequestBody OrderRecord order){
        return "Accepted order : " + order.toString();
    }
}
