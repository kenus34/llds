package org.llds.zoom;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Builder
@Setter
@ToString
public class Booking extends Entity{
    private Date createdAt;
    private int userId;
    private int vehicleId;
    private int days;
    private BookingState bookingState;
    private String paymentId;
}
