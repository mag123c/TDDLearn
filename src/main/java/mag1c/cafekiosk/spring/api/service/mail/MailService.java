package mag1c.cafekiosk.spring.api.service.mail;

import lombok.RequiredArgsConstructor;
import mag1c.cafekiosk.spring.client.mail.MailSendClient;
import mag1c.cafekiosk.spring.domain.history.mail.MailSendHistory;
import mag1c.cafekiosk.spring.domain.history.mail.MailSendHistoryRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MailService {

    private final MailSendClient mailSendClient;
    private final MailSendHistoryRepository mailSendHistoryRepository;

    public boolean sendMail(String fromEmail, String toEmail, String subject, String content) {
        boolean result = mailSendClient.sendEmail(fromEmail, toEmail, subject, content);
        if(result) {
            mailSendHistoryRepository.save(MailSendHistory.builder()
                    .fromEmail(fromEmail)
                    .toEmail(toEmail)
                    .subject(subject)
                    .content(content)
                    .build()
            );
            return true;
        }
        return false;
    }
}
