package testable;

import subs.Product;
import subs.ProductDao;

import java.util.HashMap;
import java.util.Map;

public class MemoryProductDao implements ProductDao {
    private Map<String, Product> prds = new HashMap<>();

    @Override
    public Product selectById(String productId) {
        return null;
    }
}
