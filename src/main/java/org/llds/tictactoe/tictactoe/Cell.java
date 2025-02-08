package org.llds.tictactoe.tictactoe;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    private Symbol symbol;
    boolean isEmpty(){
        return symbol==Symbol.E;
    }
}
