package org.llds.tictactoe.service;

import org.llds.tictactoe.models.Board;
import org.llds.tictactoe.models.Player;
import org.llds.tictactoe.models.Symbol;

public class GameService {
    Board board;
    public GameService(Board board){
        this.board = board;
    }
    public void play(int x, int y, Player player){
        Symbol symbol = board.play(x,y,player.getSymbol());
        if(symbol==player.getSymbol()){
            System.out.println(player.getName() + " Won");
        }
    }
}
