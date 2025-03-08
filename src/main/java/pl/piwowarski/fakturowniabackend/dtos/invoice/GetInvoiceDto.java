package pl.piwowarski.fakturowniabackend.dtos.invoice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GetInvoiceDto {

    private long id;
    private String invoiceNumber;
    private long userId;
    private LocalDate dateOfIssue;
    private LocalDate dateOfSale;
    private String originality;
    private String methodOfPayment;
    private LocalDate deadlineOfPayment;

    private String sellerFirstName;
    private String sellerLastName;
    private String sellerEmail;
    private String sellerCompanyName;
    private String sellerCompanyStreet;
    private String sellerCompanyBuildingNumber;
    private String sellerCompanyPostCode;
    private String sellerCompanyCity;
    private String sellerCompanyNip;
    private String sellerCompanyBankName;
    private String sellerCompanyBankAccountNumber;

    private String buyerCompanyName;
    private String buyerCompanyStreet;
    private String buyerCompanyBuildingNumber;
    private String buyerCompanyPostCode;
    private String buyerCompanyCity;
    private String buyerCompanyNip;
    private String buyerCompanyBankName;
    private String buyerCompanyBankAccountNumber;

    private List<GetInvoicePositionDto> getInvoicePositionDtoList;

    private String sumNetto;
    private String sumVat;
    private String sumBrutto;
}
