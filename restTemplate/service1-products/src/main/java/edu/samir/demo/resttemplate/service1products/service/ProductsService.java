package edu.samir.demo.resttemplate.service1products.service;

import edu.samir.demo.resttemplate.service1products.dto.Invoice;
import edu.samir.demo.resttemplate.service1products.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class ProductsService {

    private static final String BASE_URI = "http://localhost:9090/api";
    private final RestTemplate restTemplate;

    @Autowired
    public ProductsService(RestTemplateBuilder builder) {
        this.restTemplate = builder.rootUri("http://localhost:9090/api").build();
    }

    public Invoice createInvoice(List<Product> products) throws URISyntaxException {
        HttpEntity<List<Product>> body = new HttpEntity<>(products);
        return restTemplate.postForObject("/invoice", body, Invoice.class);
    }
}
