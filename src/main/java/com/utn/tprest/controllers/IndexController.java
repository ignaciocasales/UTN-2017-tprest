package com.utn.tprest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ignacio on 5/31/17.
 * <p>
 * Index Controller.
 */
@RestController
public class IndexController {

    @RequestMapping("/")
    public @ResponseBody
    ResponseEntity<String> index() {
        return new ResponseEntity<>("TP RESTful API by Ignacio Casales", HttpStatus.OK);
    }
}
