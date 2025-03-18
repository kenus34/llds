package org.llds.bms;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Optional;

@Builder
@Getter
public class Show {
    private Movie movie;
    private String startTime;
    private List<Seat> seats;
    public boolean book(String seatNuber){
        Optional<Seat> seat = seats.stream()
                .filter(x->x.getSeatNumber().equalsIgnoreCase(seatNuber)
                        &&x.getSeatStatus().get()==SeatStatus.AVAILABLE)
                .findFirst();
        return seat.map(Seat::bookSeat).orElse(false);
    }
}
