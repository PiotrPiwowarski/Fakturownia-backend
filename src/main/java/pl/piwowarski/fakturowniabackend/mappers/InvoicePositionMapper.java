package pl.piwowarski.fakturowniabackend.mappers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.piwowarski.fakturowniabackend.dtos.invoice.GetInvoicePositionDto;
import pl.piwowarski.fakturowniabackend.dtos.invoice.NewInvoicePosition;
import pl.piwowarski.fakturowniabackend.entites.Invoice;
import pl.piwowarski.fakturowniabackend.entites.InvoicePosition;
import pl.piwowarski.fakturowniabackend.enums.UnitOfMeasure;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class InvoicePositionMapper {

    public static InvoicePosition map(NewInvoicePosition newInvoicePosition, Invoice invoice) {
        return InvoicePosition.builder()
                .name(newInvoicePosition.getName())
                .amount(new BigDecimal(newInvoicePosition.getAmount()))
                .unitOfMeasure(UnitOfMeasure.valueOf(newInvoicePosition.getUnitOfMeasure()))
                .unitPrice(new BigDecimal(newInvoicePosition.getUnitPrice()))
                .nettoValue(new BigDecimal(newInvoicePosition.getNettoValue()))
                .vatPercent(newInvoicePosition.getVatPercent())
                .vatValue(new BigDecimal(newInvoicePosition.getVatValue()))
                .bruttoValue(new BigDecimal(newInvoicePosition.getBruttoValue()))
                .invoice(invoice)
                .build();
    }

    public static GetInvoicePositionDto map(InvoicePosition position) {
        return GetInvoicePositionDto.builder()
                .id(position.getId())
                .name(position.getName())
                .amount(position.getAmount().toString())
                .unitOfMeasure(position.getUnitOfMeasure().toString())
                .unitPrice(position.getUnitPrice().toString())
                .nettoValue(position.getNettoValue().toString())
                .vatPercent(position.getVatPercent())
                .vatValue(position.getVatValue().toString())
                .bruttoValue(position.getBruttoValue().toString())
                .build();
    }
}
