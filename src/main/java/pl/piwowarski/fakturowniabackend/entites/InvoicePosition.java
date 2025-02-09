package pl.piwowarski.fakturowniabackend.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.piwowarski.fakturowniabackend.enums.UnitOfMeasure;

import java.math.BigDecimal;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "INVOICE_POSITIONS")
public class InvoicePosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String name;
    @NotNull
    private BigDecimal amount;
    @NotNull
    @Enumerated(EnumType.STRING)
    private UnitOfMeasure unitOfMeasure;
    @NotNull
    private BigDecimal unitPrice;
    @NotNull
    private BigDecimal nettoValue;
    @NotNull
    private Integer vatPercent;
    @NotNull
    private BigDecimal vatValue;
    @NotNull
    private BigDecimal bruttoValue;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
}
