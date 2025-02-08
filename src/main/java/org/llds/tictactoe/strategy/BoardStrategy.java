package org.llds.tictactoe.strategy;

import org.llds.tictactoe.models.Board;
import org.llds.tictactoe.models.Symbol;

public interface BoardStrategy {
    Symbol success(Board board);
    int dimensionStrategy();
}
