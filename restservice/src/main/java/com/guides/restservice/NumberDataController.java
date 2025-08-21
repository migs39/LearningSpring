package com.guides.restservice;

import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class NumberDataController {
    
    private final AtomicLong id = new AtomicLong(0);

    private static int countDivisors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) count++;
        }
        return count;
    }
    
    @GetMapping("/numberData")
    public NumberData numberData(@RequestParam(defaultValue = "1") String number) {
        int n;
        try{
            n = Integer.parseInt(number);
        }
        catch (NumberFormatException e){
            n = 1;
        }
        return new NumberData(id.incrementAndGet(), n, (countDivisors(n)==2), (n%2 == 0), countDivisors(n));
    } 
}
