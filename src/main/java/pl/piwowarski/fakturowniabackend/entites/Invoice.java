package pl.piwowarski.fakturowniabackend.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.piwowarski.fakturowniabackend.enums.Originality;
import pl.piwowarski.fakturowniabackend.enums.PaymentMethod;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "INVOICES")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private LocalDate dateOfIssue;
    @NotNull
    private LocalDate dateOfSale;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Originality originality;
    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @NotNull
    private LocalDate deadlineOfPayment;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_company_id")
    private Company buyerCompany;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_company_id")
    private Company sellerCompany;
    @OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<InvoicePosition> invoicePositions = new ArrayList<>();
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
