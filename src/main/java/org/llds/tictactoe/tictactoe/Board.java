package org.llds.tictactoe.tictactoe;

import lombok.Getter;

import java.util.Arrays;

@Getter
public class Board {
    private final int dimension;
    private Cell[][] cells;
    private BoardStrategy boardStrategy;

    public Board(int dimension){
        this.dimension=dimension;
        cells = new Cell[dimension][dimension];
        for(Cell[] cells: cells){
            Arrays.setAll(cells, i->new Cell());
        }
    }

    public Symbol play(int x,int y, Symbol){

    }
}
