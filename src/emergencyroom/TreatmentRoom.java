/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emergencyroom;

/**
 *
 * @author es.carlsten
 */
public class TreatmentRoom {
    
    private Patient patient;
    
    public TreatmentRoom()
    {}
    
    public TreatmentRoom(Patient patient)
    {
        this.patient = patient;
    }
    
    public void setPatient(Patient patient)
    {
        this.patient = patient;
    }
    public Patient getPatient()
    {
        return patient;
    }
    
    public boolean isOccupied()
    {
        return patient == null;
    }
    
    public Patient removePatient()
    {
        Patient temp = patient;
        patient = null;
        return temp;
    }
    
}
