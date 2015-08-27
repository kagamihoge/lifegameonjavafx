package kagamihoge.lifegamewithoopexercise.core.cell.impl;

import kagamihoge.lifegamewithoopexercise.core.cell.Cell;
import kagamihoge.lifegamewithoopexercise.core.cell.CellFactory;
import kagamihoge.lifegamewithoopexercise.core.event.CellTransitionEventHandler;

public class CellDefaultFactory implements CellFactory{
    
    private Cell live;
    private Cell dead;
    
    public CellDefaultFactory(CellTransitionEventHandler forLive, CellTransitionEventHandler forDead) {
        super();
        live = new LiveCell(this);
        dead = new DeadCell(this);
        
        live.setEventListner(forLive);
        dead.setEventListner(forDead);
    }

    @Override
    public Cell liveCell() {
        return live;
    }
    
    @Override
    public Cell deadCell() {
        return dead;
    }

    @Override
    public Cell seedCell(double seed) {
        return new SeedCell(this, seed);
    }
}
