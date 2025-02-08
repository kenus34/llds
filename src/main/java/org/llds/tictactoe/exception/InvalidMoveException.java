package org.llds.tictactoe.exception;

public class InvalidMoveException extends RuntimeException {
    public String toString(){
        return "Invalid move";
    }
}
