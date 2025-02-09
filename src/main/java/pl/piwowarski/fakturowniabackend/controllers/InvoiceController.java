package pl.piwowarski.fakturowniabackend.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piwowarski.fakturowniabackend.dtos.invoice.NewInvoiceDto;
import pl.piwowarski.fakturowniabackend.services.invoice.InvoiceService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/invoices")
@Tag(name = "Invoices API")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Operation(summary = "Dodanie nowej faktury")
    @PostMapping("/add")
    public ResponseEntity<Void> addInvoice(@RequestBody NewInvoiceDto newInvoiceDto) {
        invoiceService.addInvoice(newInvoiceDto);
        return ResponseEntity.ok().build();
    }
}
