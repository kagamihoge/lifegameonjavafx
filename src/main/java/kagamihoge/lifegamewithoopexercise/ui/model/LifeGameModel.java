package kagamihoge.lifegamewithoopexercise.ui.model;

import static kagamihoge.lifegamewithoopexercise.ui.Cell.SIZE;

import javafx.beans.property.DoubleProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.SingleSelectionModel;
import kagamihoge.lifegameonjavafx.core.LifeGame;

public class LifeGameModel {
    private SingleSelectionModel<Integer> heightComboBoxModel;
    private SingleSelectionModel<Integer> widthComboBoxModel;
    DoubleProperty speedProperty;
    DoubleProperty seedProperty;
    private GraphicsContext graphicsContext2D;

    private LifeGame lifeGame;
    private LifeGameTimer timer;
    
    public LifeGameModel(SingleSelectionModel<Integer> heightComboBoxModel, SingleSelectionModel<Integer> widthComboBoxModel,
        DoubleProperty speedProperty,
        DoubleProperty seedProperty,
        GraphicsContext graphicsContext2D) {
        super();
        this.heightComboBoxModel = heightComboBoxModel;
        this.widthComboBoxModel = widthComboBoxModel;
        this.speedProperty = speedProperty;
        this.seedProperty = seedProperty;
        this.graphicsContext2D = graphicsContext2D;
    }

    public void init() {
        timer = null;
        Integer w = widthComboBoxModel.getSelectedItem();
        Integer h = heightComboBoxModel.getSelectedItem();
        Double seed = seedProperty.doubleValue();
        lifeGame = new LifeGame(w, h, seed, (x, y, cell) -> {
            graphicsContext2D.fillRect(x * SIZE, y * SIZE, SIZE, SIZE);
        } , (x, y, cell) -> {
        });
        lifeGame.tick();
        
        timer = new LifeGameTimer(lifeGame, graphicsContext2D, w, h, speedProperty);
    }
    
    public void flip(int x, int y) {
        lifeGame.flip(x, y);
    }
    
    public void start() {
        timer.start();
    }
    
    public void stop() {
        timer.stop();
    }

}
