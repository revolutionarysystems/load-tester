package uk.co.revsys.load.test.limit.impl;

import uk.co.revsys.load.test.limit.RateLimiter;

public class StandardRateLimiter implements RateLimiter{

    private final com.google.common.util.concurrent.RateLimiter limiter;

    public StandardRateLimiter(double permitsPerSecond) {
        limiter = com.google.common.util.concurrent.RateLimiter.create(permitsPerSecond);
    }
    
    @Override
    public void block() {
        limiter.acquire();
    }

}
