/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emergencyroom;

/**
 *
 * @author es.carlsten
 */
public class EmergencyRoom {
 
    private IPatientQueueManager patientQueueManager;
    private ITreatmentRoomManager treatmentRoomManager;
    
    public EmergencyRoom(IPatientQueueManager patientQueueManager,
            ITreatmentRoomManager treatmentRoomManager)
    {
        this.patientQueueManager = patientQueueManager;
        this.treatmentRoomManager = treatmentRoomManager;
    }
    
    public void admitPatient(Patient patient)
    {
        if (treatmentRoomManager.hasRoomAvailable())
        {
            treatmentRoomManager.assignPatient(patient);
        }
        else
        {
            patientQueueManager.insertPatient(patient);
        }
    }

    public void dischargePatient(Patient patient)
    {
        
    }
}
