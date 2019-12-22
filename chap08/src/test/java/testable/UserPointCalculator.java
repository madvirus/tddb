package testable;

import subs.NoSubscriptionException;
import subs.*;

import java.time.LocalDate;

public class UserPointCalculator {
    private PointRule pointRule = new PointRule();
    private Times times = new Times();
    private SubscriptionDao subscriptionDao;
    private ProductDao productDao;

    public UserPointCalculator(SubscriptionDao subscriptionDao,
                               ProductDao productDao) {
        this.subscriptionDao = subscriptionDao;
        this.productDao = productDao;
    }

    public void setPointRule(PointRule pointRule) {
        this.pointRule = pointRule;
    }

    public void setTimes(Times times) {
        this.times = times;
    }

    public int calculatePoint(User u) {
        Subscription s = subscriptionDao.selectByUser(u.getId());
        if (s == null) throw new NoSubscriptionException();
        Product p = productDao.selectById(s.getProductId());
        LocalDate now = times.today();
        return pointRule.calculate(s, p, now);
    }
}
