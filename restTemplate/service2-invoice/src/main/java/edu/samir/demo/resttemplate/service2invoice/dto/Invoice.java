package edu.samir.demo.resttemplate.service2invoice.dto;

import java.util.List;

public record Invoice(List<Product> products, double price) {
}
