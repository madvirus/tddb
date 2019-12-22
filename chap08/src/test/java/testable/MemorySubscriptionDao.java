package testable;

import subs.Subscription;
import subs.SubscriptionDao;

import java.util.HashMap;
import java.util.Map;

public class MemorySubscriptionDao implements SubscriptionDao {
    private Map<String, Subscription> subs = new HashMap<>();

    @Override
    public Subscription selectByUser(String id) {
        return subs.get(id);
    }

    @Override
    public void insert(Subscription subscription) {
        subs.put(subscription.getUserId(), subscription);
    }
}
