package com.daivesh.service;

import com.daivesh.domain.PlanType;
import com.daivesh.model.Subscription;
import com.daivesh.model.User;

public interface SubscriptionService {
    Subscription createSubscription(User user);

    Subscription getUserSubscription(Long userId) throws Exception;

    Subscription upgradeSubscription(Long userId, PlanType planType);

    boolean isValid(Subscription subscription);
}
