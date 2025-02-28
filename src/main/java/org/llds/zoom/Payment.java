package org.llds.zoom;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@Setter
@ToString
public class Payment extends Entity{
    private int amount;
    private PaymentType type;
    private String transactionId;
    private PaymentStatus status;
}
