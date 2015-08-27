package kagamihoge.lifegamewithoopexercise.core.cell.impl;

import kagamihoge.lifegameonjavafx.core.cell.Cell;
import kagamihoge.lifegameonjavafx.core.cell.CellFactory;
import kagamihoge.lifegameonjavafx.core.rule.DeadCellRule;
import kagamihoge.lifegamewithoopexercise.core.event.CellTransitionEventHandler;

public class DeadCell implements Cell {
    
    private CellFactory cellFactory;
    private DeadCellRule rule = new DeadCellRule();
    private CellTransitionEventHandler handler;
    
    public DeadCell(CellFactory cellFactory) {
        this.cellFactory = cellFactory;
    }

    @Override
    public boolean isLive() {
        return false;
    }
    
    @Override
    public Cell transition(int liveCells) {
        if (rule.isNewLife(liveCells)) {
            return cellFactory.liveCell();
        }
        return this;
    }
    
    @Override
    public Cell flip() {
        return cellFactory.liveCell();
    }

    @Override
    public void setEventListner(CellTransitionEventHandler handler) {
        this.handler = handler;
    }

    @Override
    public void afterTransition(int x, int y) {
        handler.handle(x, y, this);
    }
}
