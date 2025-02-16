package pl.piwowarski.fakturowniabackend.services.logout;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.piwowarski.fakturowniabackend.entites.Token;
import pl.piwowarski.fakturowniabackend.exceptions.ThisTokenIsNotActiveException;
import pl.piwowarski.fakturowniabackend.repository.TokenRepository;

@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {

    private final TokenRepository tokenRepository;

    @Transactional
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        try {
            String authHeader = request.getHeader("Authorization");
            String jwt;
            if(authHeader == null || !authHeader.startsWith("Bearer ")) {
                return;
            }
            jwt = authHeader.substring(7);
            Token token = tokenRepository.findByToken(jwt).orElseThrow(ThisTokenIsNotActiveException::new);
            tokenRepository.delete(token);
        } catch (Exception ignored) {

        }
    }
}
