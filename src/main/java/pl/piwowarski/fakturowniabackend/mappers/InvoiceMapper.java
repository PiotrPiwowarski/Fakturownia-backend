package pl.piwowarski.fakturowniabackend.mappers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.piwowarski.fakturowniabackend.dtos.invoice.NewInvoiceDto;
import pl.piwowarski.fakturowniabackend.entites.Invoice;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class InvoiceMapper {

    public static Invoice map(NewInvoiceDto newInvoiceDto) {
        return Invoice.builder().build();
    }
}
