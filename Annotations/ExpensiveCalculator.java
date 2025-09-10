import java.util.HashMap;
import java.util.Map;

public class ExpensiveCalculator {
    
    // Cache to store previously computed results
    private Map<Integer, Long> cache = new HashMap<>();

    @CacheResult
    public long factorial(int n) {
        if (cache.containsKey(n)) {
            System.out.println("Returning cached result for " + n);
            return cache.get(n);
        }

        // Expensive computation
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        // Store result in cache
        cache.put(n, result);
        System.out.println("Computed result for " + n);
        return result;
    }
}