package org.llds.tictactoe.models;

import lombok.Builder;
import lombok.Getter;
import org.llds.tictactoe.strategy.BoardStrategy;
import org.llds.tictactoe.exception.InvalidMoveException;
import org.llds.tictactoe.exception.InvalidSymbolException;

@Getter
@Builder
public class Board {
    private final int dimension;
    private Cell[][] cells;
    private BoardStrategy boardStrategy;

    public Symbol play(int x,int y, Symbol symbol) throws InvalidMoveException {
        if(x<0&&x>=dimension&&y<0&&y>=dimension){
            throw new InvalidMoveException();
        }
        if(cells[x][y].getSymbol()==Symbol.X||cells[x][y].getSymbol()==Symbol.O){
            throw new InvalidMoveException();
        }
        if(null==symbol||symbol==Symbol.E){
            throw new InvalidSymbolException();
        }
        cells[x][y].setSymbol(symbol);
        return boardStrategy.success(this);
    }
}
