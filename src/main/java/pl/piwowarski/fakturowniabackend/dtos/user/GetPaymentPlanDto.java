package pl.piwowarski.fakturowniabackend.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GetPaymentPlanDto {

    private String paymentPlan;
}
