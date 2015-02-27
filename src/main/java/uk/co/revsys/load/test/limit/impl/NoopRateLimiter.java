package uk.co.revsys.load.test.limit.impl;

import uk.co.revsys.load.test.limit.RateLimiter;

public class NoopRateLimiter implements RateLimiter{

    @Override
    public void block() {
        
    }

}
