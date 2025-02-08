package org.llds.tictactoe.strategy;

import org.llds.tictactoe.models.Board;
import org.llds.tictactoe.models.Cell;
import org.llds.tictactoe.models.Symbol;

public class ThreeByThreeBoardStrategy implements BoardStrategy{
    @Override
    public Symbol success(Board board) {
        Cell[][] cells = board.getCells();
        if(board.getDimension()!=dimensionStrategy()){
            throw new RuntimeException("Invalid board configuration");
        }
        for(int i=0;i<3;++i){
            if(cells[i][0].getSymbol()==cells[i][1].getSymbol()&&cells[i][2].getSymbol()==cells[i][1].getSymbol()&&cells[i][0].getSymbol()!=Symbol.E){
                return cells[i][0].getSymbol();
            }
            if(cells[0][i].getSymbol()==cells[1][i].getSymbol()&&cells[2][i].getSymbol()==cells[1][i].getSymbol()&&cells[0][i].getSymbol()!=Symbol.E){
                return cells[0][i].getSymbol();
            }
        }
        if(cells[0][0].getSymbol()==cells[1][1].getSymbol()&&cells[1][1].getSymbol()==cells[2][2].getSymbol()&&cells[0][0].getSymbol()!=Symbol.E){
            return cells[0][0].getSymbol();
        }
        if(cells[0][2].getSymbol()==cells[1][1].getSymbol()&&cells[1][1].getSymbol()==cells[2][0].getSymbol()&&cells[2][2].getSymbol()!=Symbol.E){
            return cells[0][2].getSymbol();
        }
        return Symbol.E;
    }

    @Override
    public int dimensionStrategy() {
        return 3;
    }
}
