package kagamihoge.lifegamewithoopexercise.ui;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CanvasSize {
    
    private static final Integer MIN_HEIGHT = Integer.valueOf(10);

    private static final Integer MAX_HEIGHT = Integer.valueOf(80);

    private static final Integer MIN_WIDTH = Integer.valueOf(10);

    private static final Integer MAX_WIDTH = Integer.valueOf(80);
    
    public static final Integer DEFAULT_SELECTED_HEIGHT = MAX_HEIGHT;
    
    public static final Integer DEFAULT_SELECTED_WIDTH = MAX_WIDTH;
    
    public ObservableList<Integer> defaultHeightObservableList() {
        return FXCollections
            .observableArrayList(IntStream.rangeClosed(MIN_HEIGHT, MAX_HEIGHT).mapToObj(Integer::valueOf).collect(Collectors.toList()));
    }
    
    public ObservableList<Integer> defaultWidthObservableList() {
        return FXCollections
            .observableArrayList(IntStream.rangeClosed(MIN_WIDTH, MAX_WIDTH).mapToObj(Integer::valueOf).collect(Collectors.toList()));
    }
}
