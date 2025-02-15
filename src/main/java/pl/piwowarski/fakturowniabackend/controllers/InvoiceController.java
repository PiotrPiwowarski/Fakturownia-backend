package pl.piwowarski.fakturowniabackend.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piwowarski.fakturowniabackend.dtos.invoice.GetInvoiceDto;
import pl.piwowarski.fakturowniabackend.dtos.invoice.GetInvoicePositionDto;
import pl.piwowarski.fakturowniabackend.dtos.invoice.NewInvoiceDto;
import pl.piwowarski.fakturowniabackend.services.invoice.InvoiceService;

import java.util.List;

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

    @Operation(summary = "Pobieranie faktur użytkownika")
    @GetMapping
    public ResponseEntity<List<GetInvoiceDto>> getUserInvoices() {
        List<GetInvoiceDto> getInvoiceDto = invoiceService.getUserInvoices();
        return ResponseEntity.ok(getInvoiceDto);
    }
}
