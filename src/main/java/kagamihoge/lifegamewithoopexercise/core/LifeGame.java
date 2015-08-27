package kagamihoge.lifegamewithoopexercise.core;

import kagamihoge.lifegamewithoopexercise.core.cell.CellFactory;
import kagamihoge.lifegamewithoopexercise.core.cell.impl.CellDefaultFactory;
import kagamihoge.lifegamewithoopexercise.core.event.CellTransitionEventHandler;
import kagamihoge.lifegamewithoopexercise.core.grid.GridOfCells;

public class LifeGame {
    private GridOfCells cells;
    
    public LifeGame(int width, int height, double seed, CellTransitionEventHandler forLive, CellTransitionEventHandler forDead) {
        CellFactory cellFactory = new CellDefaultFactory(forLive, forDead);
        this.cells = new GridOfCells(width, height, cellFactory, seed);
    }
    
    public void flip(int x, int y) {
        this.cells.flip(x, y);
    }
    
    public void tick() {
        cells = cells.generateNext();
    }
}
