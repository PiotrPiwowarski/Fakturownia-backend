package pl.piwowarski.fakturowniabackend.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.piwowarski.fakturowniabackend.enums.Role;

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
    private String companyName;
    private String street;
    private String buildingNumber;
    private String postCode;
    private String city;
    private String nip;
    private String regon;
    private String bankName;
    private String bankAccountNumber;
    private String email;
    private String phoneNumber;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private Role role;
}
