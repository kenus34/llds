package org.llds.bms;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {
    Integer id;
    String name;
    String number;
}
