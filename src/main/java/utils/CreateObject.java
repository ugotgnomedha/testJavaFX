package utils;

import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public class CreateObject {
    public Box createBox(){
        Box box = new Box();

        PhongMaterial redMaterial = new PhongMaterial();
        redMaterial.setDiffuseColor(Color.DARKRED);
        redMaterial.setSpecularColor(Color.RED);
        box.setMaterial(redMaterial);

        box.setWidth(50);
        box.setHeight(50);
        box.setDepth(50);

        return box;
    }
}
