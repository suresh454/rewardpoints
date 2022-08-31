package com.rewards.rewardpoints.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RewardsCalculatorTest {



    @Autowired
    private RewardsCalculator rewardsCalculator;

    @Test
    void calculateRewards() {
        assertEquals(90, rewardsCalculator.calculateRewards(120));
        assertEquals(120, rewardsCalculator.calculateRewards(135.56));
    }
}