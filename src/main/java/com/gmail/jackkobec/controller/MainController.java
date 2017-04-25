package com.gmail.jackkobec.controller;

import com.gmail.jackkobec.config.AppConfigHolder;
import com.gmail.jackkobec.persistence.dto.GeneralResponse;
import com.gmail.jackkobec.persistence.model.User;
import com.gmail.jackkobec.persistence.spring.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

/**
 * Created by Jack on 25.04.2017.
 */
@RestController
@Transactional
// localhost:8087/app
@RequestMapping("/app")
public class MainController {

    // @Value("${app.private-key}")  - позволяет вытягивать значение с проперти файла
    // с private доступом может не работать, или возможно нужен будет геттер и сеттер
    @Value("${app.private-key}")
    public String privateKey;


    private final UserRepository userRepository;
    private final AppConfigHolder appConfigHolder;

    @Autowired
    public MainController(UserRepository userRepository, AppConfigHolder appConfigHolder) {
        this.userRepository = userRepository;
        this.appConfigHolder = appConfigHolder;
    }

    @RequestMapping("/")
    public @ResponseBody String home() {
        return "Hello World!";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public @ResponseBody
    User getUser(@PathVariable("id") Integer id) {
        return userRepository.findOne(id);
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public ResponseEntity<GeneralResponse> postUser(@RequestBody User user) {
        User saved = userRepository.save(user);
        return new ResponseEntity<GeneralResponse>(new GeneralResponse("success"), HttpStatus.OK);
    }


}
