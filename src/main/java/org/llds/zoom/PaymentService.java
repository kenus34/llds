package org.llds.zoom;

import java.util.UUID;

public class PaymentService extends CrudService{

    @Override
    public void set(Entity oldEntity, Entity newEntity) {
        Payment old = (Payment) oldEntity;
        Payment newe = (Payment) newEntity;
        old.setAmount(newe.getAmount());
        old.setType(newe.getType());
        old.setTransactionId(newe.getTransactionId());
    }
    public String executePayment(){
        Payment payment = Payment.builder()
                .amount(100)
                .type(PaymentType.UPI)
                .transactionId(UUID.randomUUID().toString())
                .status(PaymentStatus.SUCCESS)
                .build();
        payment = (Payment) add(payment);
        return payment.getTransactionId();
    }
}
