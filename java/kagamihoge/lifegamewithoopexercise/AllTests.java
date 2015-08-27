package kagamihoge.lifegamewithoopexercise;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import kagamihoge.lifegamewithoopexercise.core.cell.DeadCellTest;
import kagamihoge.lifegamewithoopexercise.core.cell.LiveCellTest;
import kagamihoge.lifegamewithoopexercise.core.cell.SeedCellTest;
import kagamihoge.lifegamewithoopexercise.core.grid.GridOfCellsTest;
import kagamihoge.lifegamewithoopexercise.core.grid.NeighboursTest;
import kagamihoge.lifegamewithoopexercise.core.rule.DeadCellRuleTest;
import kagamihoge.lifegamewithoopexercise.core.rule.LiveCellRuleTest;

@RunWith(Suite.class)
@SuiteClasses({
    DeadCellTest.class,
    LiveCellTest.class,
    SeedCellTest.class,
    GridOfCellsTest.class,
    NeighboursTest.class,
    DeadCellRuleTest.class,
    LiveCellRuleTest.class
})
public class AllTests {

}
