package pl.piwowarski.fakturowniabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.piwowarski.fakturowniabackend.entites.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
