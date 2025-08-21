package com.guides.restservice;

public record NumberData(long requestId, int number, Boolean isPrime, Boolean isEven, int NumberOfDivisors) {
}
