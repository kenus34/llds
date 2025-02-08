package org.llds.tictactoe;

import org.llds.tictactoe.factory.ThreeByThreeBoard;
import org.llds.tictactoe.models.Player;
import org.llds.tictactoe.models.Symbol;
import org.llds.tictactoe.service.GameService;

public class TicMain {
    public static void main(String[] args) {

        GameService gameService= new GameService(new ThreeByThreeBoard().getBoard(3));
        Player player1= new Player("Kent", Symbol.X, gameService);
        Player player2= new Player("Kent", Symbol.O, gameService);
        player1.play(0,0);
        player2.play(1,0);
        player1.play(0,1);
        player2.play(2,0);
        player1.play(0,2);
    }
}
