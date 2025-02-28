package org.llds.zoom;

public class PaymentService extends CrudService{

    @Override
    public void set(Entity oldEntity, Entity newEntity) {
        Payment old = (Payment) oldEntity;
        Payment newe = (Payment) newEntity;
        old.setAmount(newe.getAmount());
        old.setType(newe.getType());
        old.setTransactionId(newe.getTransactionId());
    }
}
