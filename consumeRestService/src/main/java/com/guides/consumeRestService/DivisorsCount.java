package com.guides.consumeRestService;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DivisorsCount(int number, @JsonProperty("numberOfDivisors")int divisorsCount) {}
