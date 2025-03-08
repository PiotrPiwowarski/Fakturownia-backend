package pl.piwowarski.fakturowniabackend.mappers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.piwowarski.fakturowniabackend.dtos.invoice.GetInvoiceDto;
import pl.piwowarski.fakturowniabackend.dtos.invoice.NewInvoiceDto;
import pl.piwowarski.fakturowniabackend.entites.Company;
import pl.piwowarski.fakturowniabackend.entites.Invoice;
import pl.piwowarski.fakturowniabackend.entites.InvoicePosition;
import pl.piwowarski.fakturowniabackend.entites.User;
import pl.piwowarski.fakturowniabackend.enums.Originality;
import pl.piwowarski.fakturowniabackend.enums.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class InvoiceMapper {

    public static Invoice map(NewInvoiceDto newInvoiceDto, User user, Company buyerCompany, Company sellerCompany) {
        return Invoice.builder()
                .invoiceNumber(newInvoiceDto.getInvoiceNumber())
                .dateOfIssue(newInvoiceDto.getDateOfIssue())
                .dateOfSale(newInvoiceDto.getDateOfSale())
                .originality(Originality.valueOf(newInvoiceDto.getOriginality()))
                .deadlineOfPayment(newInvoiceDto.getDeadlineOfPayment())
                .paymentMethod(PaymentMethod.valueOf(newInvoiceDto.getMethodOfPayment()))
                .buyerCompany(buyerCompany)
                .sellerCompany(sellerCompany)
                .user(user)
                .sumNetto(new BigDecimal(newInvoiceDto.getSumNetto()))
                .sumBrutto(new BigDecimal(newInvoiceDto.getSumBrutto()))
                .sumVat(new BigDecimal(newInvoiceDto.getSumVat()))
                .build();
    }

    public static GetInvoiceDto map(Invoice invoice) {
        Company sellerCompany = invoice.getSellerCompany();
        Company buyerCompany = invoice.getBuyerCompany();

        User user = invoice.getUser();
        String sellerFirstName = user.getFirstName();
        String sellerLastName = user.getLastName();
        String sellerEmail = user.getEmail();

        return GetInvoiceDto.builder()
                .id(invoice.getId())
                .invoiceNumber(invoice.getInvoiceNumber())
                .userId(invoice.getUser().getId())
                .dateOfIssue(invoice.getDateOfIssue())
                .dateOfSale(invoice.getDateOfSale())
                .originality(invoice.getOriginality().toString())
                .methodOfPayment(invoice.getPaymentMethod().toString())
                .deadlineOfPayment(invoice.getDeadlineOfPayment())
                .sellerFirstName(sellerFirstName)
                .sellerLastName(sellerLastName)
                .sellerEmail(sellerEmail)
                .sellerCompanyName(invoice.getSellerCompany().getName())
                .sellerCompanyStreet(sellerCompany.getStreet())
                .sellerCompanyBuildingNumber(sellerCompany.getBuildingNumber())
                .sellerCompanyPostCode(sellerCompany.getPostCode())
                .sellerCompanyCity(sellerCompany.getCity())
                .sellerCompanyNip(sellerCompany.getNip())
                .sellerCompanyBankName(sellerCompany.getBankName())
                .sellerCompanyBankAccountNumber(sellerCompany.getAccountNumber())
                .buyerCompanyName(buyerCompany.getName())
                .buyerCompanyStreet(buyerCompany.getStreet())
                .buyerCompanyBuildingNumber(buyerCompany.getBuildingNumber())
                .buyerCompanyPostCode(buyerCompany.getPostCode())
                .buyerCompanyCity(buyerCompany.getCity())
                .buyerCompanyNip(buyerCompany.getNip())
                .buyerCompanyBankName(buyerCompany.getBankName())
                .buyerCompanyBankAccountNumber(buyerCompany.getAccountNumber())
                .getInvoicePositionDtoList(invoice.getInvoicePositions().stream().map(InvoicePositionMapper::map).toList())
                .sumNetto(invoice.getSumNetto().toString())
                .sumVat(invoice.getSumVat().toString())
                .sumBrutto(invoice.getSumBrutto().toString())
                .build();
    }
}

