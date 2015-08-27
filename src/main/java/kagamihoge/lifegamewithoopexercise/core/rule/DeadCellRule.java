package kagamihoge.lifegamewithoopexercise.core.rule;

public class DeadCellRule {

    public boolean isNewLife(int liveCells) {
        if (liveCells == 3) {
            return true;
        }
        return false;
    }

}
