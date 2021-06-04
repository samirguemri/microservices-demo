package edu.samir.demo.resttemplate.service2invoice.contoller;

import edu.samir.demo.resttemplate.service2invoice.dto.Invoice;
import edu.samir.demo.resttemplate.service2invoice.dto.Product;
import edu.samir.demo.resttemplate.service2invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public Invoice createInvoice(@RequestBody List<Product> productList) {
        return invoiceService.createInvoice(productList);
    }
}
