package pl.piwowarski.fakturowniabackend.dtos.invoice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NewInvoicePosition {

    private String name;
    private String amount;
    private String unitOfMeasure;
    private String unitPrice;
    private String nettoValue;
    private int vatPercent;
    private String vatValue;
    private String bruttoValue;
}
