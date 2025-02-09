package pl.piwowarski.fakturowniabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.piwowarski.fakturowniabackend.entites.InvoicePosition;

@Repository
public interface InvoicePositionRepository extends JpaRepository<InvoicePosition, Long> {
}
