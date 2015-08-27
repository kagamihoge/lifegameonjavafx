package kagamihoge.lifegamewithoopexercise.core.cell.impl;

import kagamihoge.lifegamewithoopexercise.core.cell.Cell;
import kagamihoge.lifegamewithoopexercise.core.cell.CellFactory;
import kagamihoge.lifegamewithoopexercise.core.event.CellTransitionEventHandler;
import kagamihoge.lifegamewithoopexercise.core.rule.LiveCellRule;

public class LiveCell implements Cell {
    private CellFactory cellFactory;
    private LiveCellRule rule = new LiveCellRule();
    private CellTransitionEventHandler handler;
    
    public LiveCell(CellFactory cellFactory) {
        this.cellFactory = cellFactory;
    }
    
    @Override
    public boolean isLive() {
        return true;
    }
    
    @Override
    public Cell transition(int liveCells) {
        if (rule.isUnderpopulation(liveCells)) {
            return cellFactory.deadCell();
        }
        if (rule.isOvercrowding(liveCells)) {
            return cellFactory.deadCell();
        }
        if (rule.isUnchangedSurvive(liveCells)) {
            return this;
        }
        throw new IllegalStateException();
    }

    @Override
    public Cell flip() {
        return cellFactory.deadCell();
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
