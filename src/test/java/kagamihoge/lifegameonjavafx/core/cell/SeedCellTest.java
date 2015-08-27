package kagamihoge.lifegameonjavafx.core.cell;

import static kagamihoge.lifegameonjavafx.core.cell.CellFactoryForTest.cellFactory;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import kagamihoge.lifegamewithoopexercise.core.cell.impl.SeedCell;

public class SeedCellTest {

    @Test
    public void testSeedCellToLive() {
        SeedCell cell = new SeedCell(cellFactory, 1.0);
        assertThat(cell.transition(-1).isLive(), is(true)) ;
    }

    @Test
    public void testSeedCellToDead() {
        SeedCell cell = new SeedCell(cellFactory, 0.0);
        assertThat(cell.transition(-1).isLive(), is(false)) ;
    }
}
