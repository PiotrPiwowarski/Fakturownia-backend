package pl.piwowarski.fakturowniabackend.dtos.invoice;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NewInvoicePosition {

    @NotNull
    private String name;
    @NotNull
    private String amount;
    @NotNull
    private String unitOfMeasure;
    @NotNull
    private String unitPrice;
    @NotNull
    private String nettoValue;
    private int vatPercent;
    @NotNull
    private String vatValue;
    @NotNull
    private String bruttoValue;
}
