package pl.piwowarski.fakturowniabackend.services.invoice;

import org.springframework.stereotype.Service;
import pl.piwowarski.fakturowniabackend.dtos.invoice.GetInvoiceDto;
import pl.piwowarski.fakturowniabackend.dtos.invoice.GetStatisticsDto;
import pl.piwowarski.fakturowniabackend.dtos.invoice.NewInvoiceDto;

import java.util.List;

@Service
public interface InvoiceService {
    void addInvoice(NewInvoiceDto newInvoiceDto);
    List<GetInvoiceDto> getUserInvoices();
    GetStatisticsDto getUserStatistics();
    void deleteInvoice(long id);
}
