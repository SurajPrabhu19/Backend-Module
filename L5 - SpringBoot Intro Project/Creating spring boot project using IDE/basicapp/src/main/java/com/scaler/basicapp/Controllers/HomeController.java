package com.scaler.basicapp.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    // NOTE:
    // you can name function agnostic of the route name
    // you cannot have same routes for 2 functions
    // you cannot have 2 func with same name - java syntax
    @GetMapping("/hello")
    public String helloRouteFunction() {
        return "Routed to helloRouteFunction()";
    }

    // Dynamic Mapping:
    @GetMapping("/hello/{id}")
    public String helloRouteFunctionWithId(@PathVariable String id) {
        return "Routed to helloRouteFunction() with Id: " + id;
    }

}
