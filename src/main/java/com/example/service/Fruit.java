package com.example.service;

import javax.persistence.*;

@Entity
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    private float fibonacci;

    public Fruit() {
    }

    public Fruit(String type) {
        this.name = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    
    public float getFibonacci() {
    	return fibonacci;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setFibonacci(int number) {
    	this.fibonacci = fib(number)%10000;
    }
    
    public static long fib(int n) {
    	   if(n == 0) {
    	     return 0;
    	   } else if (n == 1) {
    	     return 1;
    	   } else {
    	      return fib(n-1) + fib(n-2); //der rekursive Aufruf
    	   }
    	}

    @Override
    public String toString() {
        return "Fruit{ name='" + name + '\'' + " }";
    }
}