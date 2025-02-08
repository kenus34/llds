package org.llds.tictactoe.factory;

import org.llds.tictactoe.models.Board;

public interface BoardFactory {
    Board getBoard(int dimension);
}
