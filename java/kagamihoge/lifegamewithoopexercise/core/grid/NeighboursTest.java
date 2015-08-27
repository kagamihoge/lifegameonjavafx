package kagamihoge.lifegamewithoopexercise.core.grid;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static kagamihoge.lifegamewithoopexercise.core.cell.CellFactoryForTest.cellFactory;

import org.junit.Test;

public class NeighboursTest {

    @Test
    public void testAllDeadCell() {
        int width = 10;
        int height = 20;

        GridOfCells cells = new GridOfCells(width, height, cellFactory, 0.0);
        cells = cells.generateNext();
        Neighbours neighbours = new Neighbours(cells);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                assertThat(neighbours.countDeadCells(x, y), is(8));
            }
        }
    }
    
    @Test
    public void testCountCells() {
        int width = 10;
        int height = 20;

        GridOfCells cells = new GridOfCells(width, height, cellFactory, 0.0);
        cells = cells.generateNext();
        Neighbours neighbours = new Neighbours(cells);

        int x = 1;
        int y = 1;
        
        assertThat(neighbours.countDeadCells(x, y), is(8));
        assertThat(neighbours.countLiveCells(x, y), is(0));
        cells.flip(x - 1, y - 1);
        assertThat(neighbours.countDeadCells(x, y), is(7));
        assertThat(neighbours.countLiveCells(x, y), is(1));
        cells.flip(x, y - 1);
        assertThat(neighbours.countDeadCells(x, y), is(6));
        assertThat(neighbours.countLiveCells(x, y), is(2));
        cells.flip(x + 1, y - 1);
        assertThat(neighbours.countDeadCells(x, y), is(5));
        assertThat(neighbours.countLiveCells(x, y), is(3));
        cells.flip(x - 1, y);
        assertThat(neighbours.countDeadCells(x, y), is(4));
        assertThat(neighbours.countLiveCells(x, y), is(4));
        cells.flip(x + 1, y);
        assertThat(neighbours.countDeadCells(x, y), is(3));
        assertThat(neighbours.countLiveCells(x, y), is(5));
        cells.flip(x - 1, y + 1);
        assertThat(neighbours.countDeadCells(x, y), is(2));
        assertThat(neighbours.countLiveCells(x, y), is(6));
        cells.flip(x, y + 1);
        assertThat(neighbours.countDeadCells(x, y), is(1));
        assertThat(neighbours.countLiveCells(x, y), is(7));
        cells.flip(x + 1, y + 1);
        assertThat(neighbours.countDeadCells(x, y), is(0));
        assertThat(neighbours.countLiveCells(x, y), is(8));
    }
}
