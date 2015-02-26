package uk.co.revsys.load.test.limit;

public class RateLimiterImpl implements RateLimiter{

    private final com.google.common.util.concurrent.RateLimiter limiter;

    public RateLimiterImpl(double permitsPerSecond) {
        limiter = com.google.common.util.concurrent.RateLimiter.create(permitsPerSecond);
    }
    
    @Override
    public void block() {
        limiter.acquire();
    }

}
