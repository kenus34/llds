package org.llds.bms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

@AllArgsConstructor
@ToString
@Builder
@Getter
public class Seat {
    private AtomicReference<SeatStatus> seatStatus;
    private String seatNumber;
    public boolean bookSeat(){
       return seatStatus.compareAndSet(SeatStatus.AVAILABLE, SeatStatus.BOOKED);
    }
}
