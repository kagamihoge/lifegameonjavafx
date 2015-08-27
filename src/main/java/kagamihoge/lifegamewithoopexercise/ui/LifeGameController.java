package kagamihoge.lifegamewithoopexercise.ui;

import static kagamihoge.lifegamewithoopexercise.ui.Cell.SIZE;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Slider;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import kagamihoge.lifegamewithoopexercise.ui.eventhandler.ControllButtonOnClickHandler;
import kagamihoge.lifegamewithoopexercise.ui.eventhandler.StartButtonOnClickHander;
import kagamihoge.lifegamewithoopexercise.ui.model.LifeGameModel;

public class LifeGameController implements Initializable {
    @FXML
    TitledPane titledPane;

    @FXML
    Canvas lifegameCanvas;

    @FXML
    ComboBox<Integer> heightComboBox;

    @FXML
    ComboBox<Integer> widthComboBox;

    @FXML
    ColorPicker liveCellColorPicker;

    @FXML
    Slider seedSlider;

    @FXML
    Slider speedSlider;

    @FXML
    private Button startAndStopButton;

    @FXML
    Button resetButton;

    private LifeGameModel lifeGameModel;
    
    private GraphicsContext graphicsContext2D;

    private ControllButtonOnClickHandler startStopHandler;

    @FXML
    public void startAndStopButtonClicked(ActionEvent event) {
        startStopHandler.handle();

        startStopHandler = startStopHandler.nextHandler();
        startAndStopButton.setText(startStopHandler.getText());
    }

    @FXML
    public void resetButtonClieckd(ActionEvent event) {
        lifeGameModel.stop();
        graphicsContext2D.clearRect(0, 0, lifegameCanvas.getWidth(), lifegameCanvas.getHeight());
        lifeGameModel.init();
        startStopHandler = new StartButtonOnClickHander(lifeGameModel);
        startAndStopButton.setText(startStopHandler.getText());
    }

    @FXML
    public void colorchanged(ActionEvent e) {
        graphicsContext2D.setFill(liveCellColorPicker.valueProperty().get());
    }

    @FXML
    public void canvasclicked(MouseEvent mv) {
        int x = (int) (Math.floor(mv.getX())) / SIZE;
        int y = (int) (Math.floor(mv.getY())) / SIZE;
        lifeGameModel.flip(x, y);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        liveCellColorPicker.valueProperty().set(Color.BLACK);
        graphicsContext2D = lifegameCanvas.getGraphicsContext2D();

        CanvasSize canvasSize = new CanvasSize();

        initSizeComboBox(heightComboBox, canvasSize.defaultHeightObservableList());
        initSizeComboBox(widthComboBox, canvasSize.defaultWidthObservableList());

        lifeGameModel = new LifeGameModel(heightComboBox.getSelectionModel(), widthComboBox.getSelectionModel(),
            speedSlider.valueProperty(), seedSlider.valueProperty(), graphicsContext2D);
        lifeGameModel.init();

        startStopHandler = new StartButtonOnClickHander(lifeGameModel);
    }

    private static void initSizeComboBox(ComboBox<Integer> comboBox, ObservableList<Integer> list) {
        comboBox.itemsProperty().set(list);
        SingleSelectionModel<Integer> comboBoxModel = comboBox.getSelectionModel();
        comboBoxModel.select(Integer.valueOf(CanvasSize.DEFAULT_SELECTED_HEIGHT));
    }
}
