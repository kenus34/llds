package org.llds.zoom;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@Setter
@ToString
public class User extends Entity{
    private String name;
    private Long number;
    private UserStatus status;
}
