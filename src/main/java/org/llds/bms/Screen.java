package org.llds.bms;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Screen {
    List<Show> shows;
    ScreenType screenType;
    public boolean bookSeat(int showNumber, String seatNumber){
        if(shows.size()<=showNumber){
            return false;
        }else{
            return shows.get(showNumber).book(seatNumber);
        }
    }
}
