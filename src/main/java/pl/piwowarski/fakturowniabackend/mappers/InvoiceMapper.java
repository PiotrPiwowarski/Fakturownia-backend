package pl.piwowarski.fakturowniabackend.mappers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.piwowarski.fakturowniabackend.dtos.invoice.GetInvoiceDto;
import pl.piwowarski.fakturowniabackend.dtos.invoice.GetInvoicePositionDto;
import pl.piwowarski.fakturowniabackend.dtos.invoice.NewInvoiceDto;
import pl.piwowarski.fakturowniabackend.entites.Company;
import pl.piwowarski.fakturowniabackend.entites.Invoice;
import pl.piwowarski.fakturowniabackend.entites.User;
import pl.piwowarski.fakturowniabackend.enums.Originality;
import pl.piwowarski.fakturowniabackend.enums.PaymentMethod;

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

    public static GetInvoiceDto map(Invoice invoice) {
        Company sellerCompany = invoice.getSellerCompany();
        Company buyerCompany = invoice.getBuyerCompany();
        return GetInvoiceDto.builder()
                .id(invoice.getId())
                .userId(invoice.getUser().getId())
                .dateOfIssue(invoice.getDateOfIssue())
                .dateOfSale(invoice.getDateOfSale())
                .originality(invoice.getOriginality().toString())
                .methodOfPayment(invoice.getPaymentMethod().toString())
                .deadlineOfPayment(invoice.getDeadlineOfPayment())
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
                .getInvoicePositionDtoList(invoice.getInvoicePositions().stream().map(position -> InvoicePositionMapper.map(position)).toList())
                .build();
    }
}

