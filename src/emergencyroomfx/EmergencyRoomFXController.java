/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emergencyroomfx;

import emergencyroom.EmergencyRoom;
import emergencyroom.IPatientQueueManager;
import emergencyroom.ITreatmentRoomManager;
import emergencyroom.MultipleTreatmentRoomManager;
import emergencyroom.Patient;
import emergencyroom.PrioritizedPatientQueueManager;
import emergencyroom.TreatmentRoom;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 *
 * @author es.carlsten
 */
public class EmergencyRoomFXController implements Initializable {
    
    @FXML
    Button newButton;
    
    @FXML
    ListView<TreatmentRoom> treatmentRoomList;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        Callback<ListView<TreatmentRoom>, ListCell<TreatmentRoom>> treatmentRoomCellFactory =
                new Callback<ListView<TreatmentRoom>, ListCell<TreatmentRoom>>()
                {
                    @Override
                    public ListCell<TreatmentRoom> call(ListView<TreatmentRoom> room)
                    {
                        return new TreatmentRoomListCell();
                    }
                };
        
        //treatmentRoomList = new ListView<>();
        LinkedList<TreatmentRoom> list = new LinkedList<>();
        list.add(new TreatmentRoom(new Patient(1, 3)));
        list.add(new TreatmentRoom(new Patient(3, 2)));
        ObservableList<TreatmentRoom> oList = FXCollections.observableList(list);
        treatmentRoomList.setItems(oList);
        treatmentRoomList.setCellFactory(treatmentRoomCellFactory);
        
        System.out.println("done initializing");
    }    
    
    public void newButtonAction(ActionEvent event)
    {
        System.out.println("newButtonAction");
        final int patientQueueCount = 4;
        final int treatmentRoomCount = 2;
        
        IPatientQueueManager patientQueueManager = new PrioritizedPatientQueueManager(patientQueueCount);
        ITreatmentRoomManager treatmentRoomManager = new MultipleTreatmentRoomManager(treatmentRoomCount);
        
        EmergencyRoom er = new EmergencyRoom(patientQueueManager, treatmentRoomManager);
        
        for (int i = 1; i < 10; i++)
        {
            Patient patient = new Patient(i, (i-1)%4+1);
            er.admitPatient(patient);
        }
        
        System.out.println("done building ER object");
    }
    
}
