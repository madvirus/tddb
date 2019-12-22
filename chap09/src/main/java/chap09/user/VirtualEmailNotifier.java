package chap09.user;

import org.springframework.stereotype.Component;

@Component
public class VirtualEmailNotifier implements EmailNotifier {
    @Override
    public void sendRegisterEmail(String email) {
        System.out.println("메일 발송: " + email);
    }
}
