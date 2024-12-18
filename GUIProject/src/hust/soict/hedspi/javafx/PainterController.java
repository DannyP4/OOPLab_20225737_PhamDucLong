package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private ToggleGroup a;

    @FXML
    private Pane drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if (isPenSelected()) {
            Circle pen = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
            drawingAreaPane.getChildren().add(pen);
        } else {
            Circle eraser = new Circle(event.getX(), event.getY(), 20, Color.WHITE);
            drawingAreaPane.getChildren().add(eraser);
        }
    }

    private boolean isPenSelected() {
        RadioButton selectedRadioButton = (RadioButton) a.getSelectedToggle();
        return selectedRadioButton != null && "Pen".equals(selectedRadioButton.getText());
    }
}
