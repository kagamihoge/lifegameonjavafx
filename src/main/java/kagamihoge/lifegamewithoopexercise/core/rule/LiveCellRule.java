package kagamihoge.lifegamewithoopexercise.core.rule;

public class LiveCellRule {
    
    public boolean isUnderpopulation(int liveCells) {
        if (liveCells == 0 || liveCells == 1) {
            return true;
        }
        return false;
    }
    
    public boolean isOvercrowding(int liveCells) {
        if (liveCells >= 4) {
            return true;
        }
        return false;
    }
    
    public boolean isUnchangedSurvive(int liveCells) {
        if (liveCells == 2 || liveCells == 3) {
            return true;
        }
        return false;
    }
    
}
