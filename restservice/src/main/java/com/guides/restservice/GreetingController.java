package com.guides.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class GreetingController {

    private static final String content = "Hello %s :)";
    private final AtomicLong id = new AtomicLong(0);

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(defaultValue = "world") String name) {
        return new Greeting(id.getAndIncrement(), String.format(content,name));
    }
}
