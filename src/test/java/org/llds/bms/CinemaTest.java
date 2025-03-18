package org.llds.bms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class CinemaTest {

    @Test
    void book() {
        Movie movie = Movie.builder()
                .name("Terminator")
                .director("James Cameroon")
                .cast(Collections.singletonList("Arnold"))
                .genre(Collections.singletonList("SciFi"))
                .build();
        List<Seat> seats = new ArrayList<>();
        for(int i=0;i<100;++i){
            seats.add(Seat.builder()
                            .seatNumber(i+"")
                            .seatStatus(new AtomicReference<>(SeatStatus.AVAILABLE))
                    .build());
        }
        Show show = Show.builder()
                .movie(movie)
                .seats(seats)
                .startTime("9:00")
                .build();
        Screen screen = Screen.builder()
                .shows(Collections.singletonList(show))
                .screenType(ScreenType.DOLBY)
                .build();
        Cinema cinema = Cinema.builder()
                .cinemaName("Chembakassery")
                .screens(Collections.singletonList(screen))
                .build();
        System.out.println(cinema.book(0, 0, "1"));
        System.out.println(cinema.book(0, 0, "1"));
    }
}