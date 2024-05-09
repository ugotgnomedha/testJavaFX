package controllers;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class MainController {
    private final double[] dragDelta = new double[2];

    @FXML
    private Box box;

    @FXML
    void onClickBox(MouseEvent event) {
        // Start animation.
        rotate();
    }

    @FXML
    void onMousePressedBox(MouseEvent event) {
        System.out.println("pressed");
        dragDelta[0] = event.getX() - box.getTranslateX();
        dragDelta[1] = event.getY() - box.getTranslateY();
    }

    @FXML
    void onMouseDraggedBox(MouseEvent event) {
        box.setTranslateX(event.getX() - dragDelta[0]);
        box.setTranslateY(event.getY() - dragDelta[1]);
    }

    public void initialize() {
        // Set cube's color.
        setCubeMaterial();
    }

    private void setCubeMaterial(){
        final PhongMaterial redMaterial = new PhongMaterial();
        redMaterial.setDiffuseColor(Color.DARKRED);
        redMaterial.setSpecularColor(Color.RED);
        box.setMaterial(redMaterial);
    }

    private void rotate() {
        Rotate rotation = new Rotate(200, Rotate.Z_AXIS);
        Rotate rotation1 = new Rotate(0, Rotate.X_AXIS);
        Rotate rotation2 = new Rotate(0, Rotate.Y_AXIS);
        box.getTransforms().add(rotation);
        box.getTransforms().add(rotation1);
        box.getTransforms().add(rotation2);

        // Set rotation angles and create timelines for each rotation
        Timeline timeline1 = createRotationTimeline(rotation, Duration.seconds(30), 360);
        Timeline timeline2 = createRotationTimeline(rotation1, Duration.seconds(5), 360);
        Timeline timeline3 = createRotationTimeline(rotation2, Duration.seconds(5), 360);

        timeline1.play(); // Start animation.
        timeline2.play();
        timeline3.play();
    }

    private Timeline createRotationTimeline(Rotate rotation, Duration duration, double angle) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(rotation.angleProperty(), 0)),
                new KeyFrame(duration, new KeyValue(rotation.angleProperty(), angle))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        return timeline;
    }
}