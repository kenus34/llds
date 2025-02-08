package org.llds.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Cell {
    private Symbol symbol;
    boolean isEmpty(){
        return symbol==Symbol.E;
    }
}
