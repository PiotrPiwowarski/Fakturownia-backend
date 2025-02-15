package pl.piwowarski.fakturowniabackend.mappers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.piwowarski.fakturowniabackend.dtos.invoice.NewInvoiceDto;
import pl.piwowarski.fakturowniabackend.entites.Company;
import pl.piwowarski.fakturowniabackend.entites.Invoice;
import pl.piwowarski.fakturowniabackend.entites.User;
import pl.piwowarski.fakturowniabackend.enums.Originality;
import pl.piwowarski.fakturowniabackend.enums.PaymentMethod;

import java.util.ArrayList;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class InvoiceMapper {

    public static Invoice map(NewInvoiceDto newInvoiceDto, User user, Company buyerCompany, Company sellerCompany) {
        return Invoice.builder()
                .dateOfIssue(newInvoiceDto.getDateOfIssue())
                .dateOfSale(newInvoiceDto.getDateOfSale())
                .originality(Originality.valueOf(newInvoiceDto.getOriginality()))
                .deadlineOfPayment(newInvoiceDto.getDeadlineOfPayment())
                .paymentMethod(PaymentMethod.valueOf(newInvoiceDto.getMethodOfPayment()))
                .buyerCompany(buyerCompany)
                .sellerCompany(sellerCompany)
                .user(user)
                .build();
    }
}

