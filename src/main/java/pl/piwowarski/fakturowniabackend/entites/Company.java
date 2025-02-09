package pl.piwowarski.fakturowniabackend.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "COMPANIES")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String name;
    @NotNull
    private String street;
    @NotNull
    private String buildingNumber;
    @NotNull
    @Pattern(regexp = "^[0-9]{2}-[0-9]{3}$")
    private String postCode;
    @NotNull
    private String city;
    @NotNull
    @Column(unique = true, length = 10)
    private String nip;
    private String bankName;
    @Column(unique = true, length = 26)
    private String accountNumber;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
