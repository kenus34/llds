package org.llds.zoom;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class User extends Entity{
    private String name;
    private Long number;
    private UserStatus status;
}
