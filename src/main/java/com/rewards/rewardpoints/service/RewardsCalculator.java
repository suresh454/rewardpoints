package com.rewards.rewardpoints.service;

import com.rewards.rewardpoints.model.RewardPoints;
import org.springframework.stereotype.Service;

@Service
public class RewardsCalculator {

    public RewardPoints calculateRewards(double totalBill) {

        RewardPoints rewardPoints = new RewardPoints(0);
        int points = 0;
        int bill = (int) totalBill;
        while(bill > 0) {
            if(bill > 100) {
                points = (bill - 100) * 2;
                bill = 100;
            } else if(bill > 50 && bill <= 100) {
                points = points + (bill - 50);
                bill = 0;
            }
        }
        rewardPoints.setTotalPoints(points);
        return rewardPoints;
    }
}
