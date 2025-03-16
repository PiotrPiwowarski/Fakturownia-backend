package pl.piwowarski.fakturowniabackend.dtos.invoice;

import jakarta.validation.constraints.NotNull;
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
public class NewInvoiceDto {

    @NotNull
    private String invoiceNumber;
    @NotNull
    private LocalDate dateOfIssue;
    @NotNull
    private LocalDate dateOfSale;
    @NotNull
    private String originality;
    @NotNull
    private String methodOfPayment;
    @NotNull
    private LocalDate deadlineOfPayment;

    @NotNull
    private String sellerCompanyName;
    @NotNull
    private String sellerCompanyStreet;
    @NotNull
    private String sellerCompanyBuildingNumber;
    @NotNull
    private String sellerCompanyPostCode;
    @NotNull
    private String sellerCompanyCity;
    @NotNull
    private String sellerCompanyNip;
    @NotNull
    private String sellerCompanyBankName;
    @NotNull
    private String sellerCompanyBankAccountNumber;

    @NotNull
    private String buyerCompanyName;
    @NotNull
    private String buyerCompanyStreet;
    @NotNull
    private String buyerCompanyBuildingNumber;
    @NotNull
    private String buyerCompanyPostCode;
    @NotNull
    private String buyerCompanyCity;
    @NotNull
    private String buyerCompanyNip;
    @NotNull
    private String buyerCompanyBankName;
    @NotNull
    private String buyerCompanyBankAccountNumber;

    @NotNull
    private String sumNetto;
    @NotNull
    private String sumBrutto;
    @NotNull
    private String sumVat;

    private List<NewInvoicePosition> newInvoicePositionList;
}
