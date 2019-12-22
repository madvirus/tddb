package auth;

public interface CustomerRepository {
    Customer findOne(String id);
}
