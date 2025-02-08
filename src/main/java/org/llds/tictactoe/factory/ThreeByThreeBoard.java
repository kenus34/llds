package org.llds.tictactoe.factory;

import org.llds.tictactoe.models.Board;
import org.llds.tictactoe.models.Cell;
import org.llds.tictactoe.models.Symbol;
import org.llds.tictactoe.strategy.ThreeByThreeBoardStrategy;

import java.util.Arrays;

public class ThreeByThreeBoard implements BoardFactory {

    @Override
    public Board getBoard(int dimension) {
        Cell[][] cells = new Cell[dimension][dimension];
        for(Cell[] cell: cells){
            Arrays.setAll(cell, i->new Cell(Symbol.E));
        }
        return Board.builder()
                .dimension(dimension)
                .cells(cells)
                .boardStrategy(new ThreeByThreeBoardStrategy())
                .build();
    }
}
