package pl.piwowarski.fakturowniabackend.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.piwowarski.fakturowniabackend.entites.Company;
import pl.piwowarski.fakturowniabackend.entites.Invoice;
import pl.piwowarski.fakturowniabackend.entites.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    List<Invoice> findAllByUserOrderByDateOfIssueDesc(User user);
    @Query("SELECT i FROM Invoice i WHERE i.user = :user ORDER BY i.dateOfIssue DESC")
    List<Invoice> findByUserOrderByDateOfIssueDescPageable(User user, Pageable pageable);
    Optional<Invoice> findByIdAndUser(long id, User user);
    @Transactional
    @Modifying
    void deleteAllByBuyerCompany(Company company);
    @Transactional
    @Modifying
    void deleteAllBySellerCompany(Company company);
}
