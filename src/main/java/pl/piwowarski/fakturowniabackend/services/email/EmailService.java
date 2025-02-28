package pl.piwowarski.fakturowniabackend.services.email;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {

    void sendEmail(String to, String subject, String content);
}
