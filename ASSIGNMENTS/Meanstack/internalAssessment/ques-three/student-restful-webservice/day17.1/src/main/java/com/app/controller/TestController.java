package com.app.controller;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	public TestController() {
		System.out.println("in ctor "+getClass().getName());
	}
	@GetMapping
	public Set<Integer> testMe()
	{
		System.out.println("in test me");
		return new LinkedHashSet<>(Arrays.asList(12,34,23,45,12,78));
	}
}
