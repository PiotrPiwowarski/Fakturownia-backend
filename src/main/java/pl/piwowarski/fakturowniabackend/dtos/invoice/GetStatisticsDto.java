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
public class GetStatisticsDto {

    private int amount;
    @NotNull
    private String sumNettoValue;
    @NotNull
    private String averageInvoiceValue;
}
