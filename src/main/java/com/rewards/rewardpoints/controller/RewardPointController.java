package com.rewards.rewardpoints.controller;

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
    public int getRewardpoints(@PathVariable double totalBill){
        log.info("Calculating rewards for {}", totalBill);
        int rewards = rewardsCalculator.calculateRewards(totalBill);
        log.info("Total rewards {}", rewards);
        return rewards;
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleTypeMismatch(MethodArgumentTypeMismatchException ex){
        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("Please provide numeric value");
    }

    public ResponseEntity<String> handleAnyError(Exception ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unable to process your request at this time");
    }
}
