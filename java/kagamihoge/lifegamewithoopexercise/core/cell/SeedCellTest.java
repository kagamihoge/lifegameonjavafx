package kagamihoge.lifegamewithoopexercise.core.cell;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static kagamihoge.lifegamewithoopexercise.core.cell.CellFactoryForTest.cellFactory;

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
