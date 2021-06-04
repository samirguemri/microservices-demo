package edu.samir.demo.resttemplate.service1products.controller;

import edu.samir.demo.resttemplate.service1products.dto.Invoice;
import edu.samir.demo.resttemplate.service1products.dto.Product;
import edu.samir.demo.resttemplate.service1products.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public Invoice createInvoice(@RequestBody List<Product> products) throws URISyntaxException {
        return productsService.createInvoice(products);
    }

}
