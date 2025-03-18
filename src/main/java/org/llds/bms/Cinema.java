package org.llds.bms;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@AllArgsConstructor
@Builder
public class Cinema {
    private String cinemaName;
    private List<Screen> screens;
    public boolean book(int screenNumber, int showNumber, String seatNumber){
        if(screens.size()>screenNumber){
            return screens.get(screenNumber).bookSeat(showNumber, seatNumber);
        }else{
            return false;
        }
    }
}
