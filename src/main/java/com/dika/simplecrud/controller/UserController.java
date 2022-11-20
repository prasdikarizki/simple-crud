package com.dika.simplecrud.controller;

import com.dika.simplecrud.dto.DataReq;
import com.dika.simplecrud.dto.UserBodyReq;
import com.dika.simplecrud.entity.UserEntity;
import com.dika.simplecrud.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String sayHello(){
        var a = 50;
        return "Hello World "+a;
    }

    @GetMapping("/params")
    public String sayHelloWithParams(@RequestParam String name){
        return "Hello World "+name;
    }

    @GetMapping("/path/{name}")
    public String sayHelloWithPath(@PathVariable String name){
        return "Hello World "+name;
    }

    @GetMapping("/body")
    public String sayHelloWithBody(@RequestBody DataReq body){
        return "Hello World "+body.getName()+" with age "+ body.getAge();
    }

    @GetMapping("/all")
    public List<UserEntity> getAll(){
        return userService.getAll();
    }

    @PostMapping("")
    public UserEntity create(@RequestBody UserEntity userBodyReq) {

        return userService.create(userBodyReq);
    }

    @DeleteMapping("")
    public String delete(@RequestParam int id) {
        userService.delete(id);
        return "success fully deleted";
    }

    @DeleteMapping("/{id}")
    public String deletePath(@PathVariable("id") int path) {
        userService.delete(path);
        return "success fully deleted";
    }

    @DeleteMapping("/body")
    public String deleteBody(@RequestBody DataReq body) {
        userService.deleteByName(body.getName());
        return "success fully deleted";
    }

    @PutMapping("/{nama}")
    public String updateParam(@RequestParam int id, @RequestBody DataReq body, @PathVariable("nama") String email) {
        userService.update(id, body, email);
        return "success fully updatedjimg";
    }
}