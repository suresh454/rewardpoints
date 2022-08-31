package com.rewards.rewardpoints.service;

import org.springframework.stereotype.Service;

@Service
public class RewardsCalculator {

    public int calculateRewards(double totalBill) {

        int rewardPoints = 0;
        int bill = (int) totalBill;
        while(bill >= 0) {
            if(bill > 100) {
                rewardPoints = (bill - 100) * 2;
                bill = 100;
            } else if(bill > 50 && bill <= 100) {
                rewardPoints = rewardPoints + (bill - 50);
                bill = 0;
            } else {
                return rewardPoints;
            }
        }
        return rewardPoints;
    }
}
