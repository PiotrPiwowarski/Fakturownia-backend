package pl.piwowarski.fakturowniabackend.dtos.invoice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GetStatisticsDto {

    private int amount;
    private String sumNettoValue;
    private String averageInvoiceValue;
}
