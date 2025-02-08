package org.llds.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.llds.tictactoe.service.GameService;

@AllArgsConstructor
@Getter
@ToString
public class Player {
    private String name;
    private Symbol symbol;
    GameService gameService;
    public void play(int x,int y){
        gameService.play(x,y,this);
    }
}
