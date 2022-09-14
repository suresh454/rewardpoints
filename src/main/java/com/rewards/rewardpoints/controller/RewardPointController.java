package com.rewards.rewardpoints.controller;

import com.rewards.rewardpoints.model.RewardPoints;
import com.rewards.rewardpoints.service.RewardsCalculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@RestController
@Slf4j
@RequestMapping("/rewards")
public class RewardPointController {


    @Autowired
    RewardsCalculator rewardsCalculator;

    @GetMapping("/{totalBill}")
    public RewardPoints getRewardpoints(@PathVariable double totalBill){
        log.info("Calculating rewards for {}", totalBill);
        RewardPoints rewards = rewardsCalculator.calculateRewards(totalBill);
        log.info("Total rewards {}", rewards);
        return rewards;
    }


}
