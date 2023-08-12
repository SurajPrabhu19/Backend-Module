package com.scaler.basicapp;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetPostDemo {

    private ArrayList<String> arr = new ArrayList<>();

    // GET
    @GetMapping("/getValue/{id}")
    public String getValue(@PathVariable String id) {
        if (arr.size() <= 0 || arr.size() < Integer.parseInt(id))
            return "Nothing present";
        return arr.get(Integer.parseInt(id));
    }

    // POST: http://127.0.0.1:8081/addValue
    // always keep the key as @RequestParam i.e. "value"
    // <key:value, item:"item1">
    // put something as a value for testing
    @PostMapping("/addValue")
    public void addValue(@RequestParam String value) {
        System.out.println(value + " added to List");
        arr.add(value);
    }

}
