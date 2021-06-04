package edu.samir.demo.resttemplate.service2invoice.service;

import edu.samir.demo.resttemplate.service2invoice.dto.Invoice;
import edu.samir.demo.resttemplate.service2invoice.dto.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    public Invoice createInvoice(List<Product> productList) {
        double price = productList.stream().mapToDouble(Product::price).sum();
        return new Invoice(productList, price);
    }
}
