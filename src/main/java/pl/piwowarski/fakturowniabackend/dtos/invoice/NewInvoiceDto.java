package pl.piwowarski.fakturowniabackend.dtos.invoice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NewInvoiceDto {

    private String dateOfIssue;
    private String dateOfSale;
    private String originality;
    private String methodOfPayment;
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
}
