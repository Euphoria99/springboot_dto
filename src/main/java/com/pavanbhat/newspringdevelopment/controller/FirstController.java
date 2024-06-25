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

    @GetMapping("/hello/{user-name}")
    public String pathVar(@PathVariable("user-name") String userName){

        return "my value equals = " + userName;
    }

    //localhost:8080/full-name?param_name_1=value_1&param_name_2=value_2
    @GetMapping("/full-name")
    public String paramVar(@RequestParam("first-name") String firstName,@RequestParam("last-name") String lastName ){
        return "The name is " + firstName + "  " + lastName;
    }
}
