package org.llds.tictactoe.exception;

public class InvalidSymbolException extends RuntimeException {
    public String toString(){
        return "Invalid shape";
    }
}
