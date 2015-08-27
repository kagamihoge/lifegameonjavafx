package kagamihoge.lifegamewithoopexercise.core.cell;

import kagamihoge.lifegamewithoopexercise.core.cell.impl.CellDefaultFactory;

public class CellFactoryForTest {
    public static CellFactory cellFactory = new CellDefaultFactory(
        (x, y, cell) -> {}, (x, y, cell) -> {});
}
