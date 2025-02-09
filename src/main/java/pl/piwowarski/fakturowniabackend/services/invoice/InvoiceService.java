package pl.piwowarski.fakturowniabackend.services.invoice;

import org.springframework.stereotype.Service;
import pl.piwowarski.fakturowniabackend.dtos.invoice.NewInvoiceDto;

@Service
public interface InvoiceService {
    void addInvoice(NewInvoiceDto newInvoiceDto);
}
