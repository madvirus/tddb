package autodebit;

import java.time.LocalDateTime;

public class AutoDebitInfo {
    private String userId;
    private String cardNumber;
    private LocalDateTime registTime;
    private LocalDateTime updateTime;

    public AutoDebitInfo(String userId, String cardNumber, LocalDateTime registTime) {
        this.userId = userId;
        this.cardNumber = cardNumber;
        this.registTime = registTime;
        this.updateTime = registTime;
    }

    public String getUserId() {
        return userId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public LocalDateTime getRegistTime() {
        return registTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void changeCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        this.updateTime = LocalDateTime.now();
    }
}
