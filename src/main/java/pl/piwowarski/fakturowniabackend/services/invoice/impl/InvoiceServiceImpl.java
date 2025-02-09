package pl.piwowarski.fakturowniabackend.services.invoice.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piwowarski.fakturowniabackend.dtos.invoice.NewInvoiceDto;
import pl.piwowarski.fakturowniabackend.entites.Invoice;
import pl.piwowarski.fakturowniabackend.mappers.InvoiceMapper;
import pl.piwowarski.fakturowniabackend.repository.InvoiceRepository;
import pl.piwowarski.fakturowniabackend.services.invoice.InvoiceService;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Override
    public void addInvoice(NewInvoiceDto newInvoiceDto) {
        Invoice invoice = InvoiceMapper.map(newInvoiceDto);
    }
}
