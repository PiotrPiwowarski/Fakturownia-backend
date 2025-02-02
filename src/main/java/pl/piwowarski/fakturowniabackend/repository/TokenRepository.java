package pl.piwowarski.fakturowniabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import pl.piwowarski.fakturowniabackend.entites.Token;
import pl.piwowarski.fakturowniabackend.entites.User;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {

    Optional<Token> findByToken(String token);
    @Modifying
    @Transactional
    void deleteAllByUser(User user);
}
