package kagamihoge.lifegamewithoopexercise.core.cell.impl;

import kagamihoge.lifegamewithoopexercise.core.cell.Cell;
import kagamihoge.lifegamewithoopexercise.core.cell.CellFactory;
import kagamihoge.lifegamewithoopexercise.core.event.CellTransitionEventHandler;

public class SeedCell implements Cell {

    private CellFactory cellFactory;
    private double seed;
    
    public SeedCell(CellFactory cellFactory, double seed) {
        this.cellFactory = cellFactory;
        this.seed = seed;
    }
    
    @Override
    public Cell transition(int liveCells) {
        if (Math.random() < seed) {
            return cellFactory.liveCell();
        }
        return cellFactory.deadCell();
    }

    @Override
    public boolean isLive() {
        return false;
    }

    @Override
    public Cell flip() {
        return cellFactory.deadCell();
    }

    @Override
    public void setEventListner(CellTransitionEventHandler handler) {

    }

    @Override
    public void afterTransition(int x, int y) {
        
    }
}
