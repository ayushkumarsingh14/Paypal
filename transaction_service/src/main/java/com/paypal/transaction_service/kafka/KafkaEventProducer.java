package com.paypal.transaction_service.kafka;

public class KafkaEventProducer {

    private final KafkaTemplate<String, Transaction> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public KafkaEventProducer(KafkaEventProducer<String, Transaction> kafkaEventProducer, ObjectMapper objectMapper){
        this.kafkaEventProducer = kafkaEventProducer;
        this.objectMapper = objectMapper;
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    public void sendTransactionEvent(String key, Transaction transaction){
        
    }
}