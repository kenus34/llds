package org.llds.bms;

import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
public class Movie {
    String name;
    String director;
    List<String> cast;
    List<String> genre;
    int runtime;
}
