/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emergencyroomfx;

import emergencyroom.TreatmentRoom;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author es.carlsten
 */
public class TreatmentRoomListCell extends ListCell<TreatmentRoom> {
    
    public TreatmentRoomListCell()
    {}
    
    @Override
    public void updateItem(TreatmentRoom item, boolean empty)
    {
        super.updateItem(item, empty);
        
        setStyle("-fx-padding: 0; -fx-background-color: lightgray");
        
        if (item != null)
        {
            DropShadow shadow = new DropShadow();
            shadow.setOffsetX(1);
            shadow.setOffsetY(1);
            
            Rectangle outerRect = new Rectangle(100,76);
            outerRect.setOpacity(0.0);
            outerRect.setFill(Color.BLACK);
            
            Rectangle rect = new Rectangle(85,65);
            rect.setFill(Color.LIGHTSLATEGRAY);
            rect.setArcHeight(15);
            rect.setArcWidth(15);
            rect.setEffect(shadow);
            
            double rectTranslate = (outerRect.getHeight() - rect.getHeight()) / 2;
            
            rect.setTranslateX(rectTranslate);
            rect.setTranslateY(rectTranslate);
            
            Pane pane = new Pane();
            pane.getChildren().addAll(outerRect, rect);
            
            setGraphic(pane);
        }
    }
    
}
