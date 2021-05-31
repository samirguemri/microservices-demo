package edu.samir.demo.resttemplate.service1products.dto;

import java.util.List;

public record Invoice(List<Product> products, double price) {
}
