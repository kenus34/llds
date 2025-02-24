package org.llds.zoom;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Builder
@Setter
@ToString
public class Store extends Entity{
    private String name;
    private int locationId;
}
