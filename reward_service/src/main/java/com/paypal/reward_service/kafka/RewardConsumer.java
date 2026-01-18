package com.paypal.reward_service.kafka;

import com.paypal.reward_service.entity.Reward;
import com.paypal.reward_service.entity.Transaction;
import com.paypal.reward_service.repository.RewardRepository;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RewardConsumer {

    private final RewardRepository rewardRepository;

    public RewardConsumer(RewardRepository rewardRepository) {
        this.rewardRepository = rewardRepository;
    }

    @KafkaListener(topics = "txn-initiated", groupId = "reward-group")
    public void consumeTransaction(Transaction transaction) {

        if (rewardRepository.existsByTransactionId(transaction.getId())) {
            System.out.println("⚠️ Reward already exists for transaction: " + transaction.getId());
            return;
        }

        Reward reward = new Reward();
        reward.setUserId(transaction.getSenderId());
        reward.setPoints(transaction.getAmount() * 100);
        reward.setSentAt(LocalDateTime.now());
        reward.setTransactionId(transaction.getId());

        rewardRepository.save(reward);
        System.out.println("✅ Reward saved: " + reward);
    }
}
