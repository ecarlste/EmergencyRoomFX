/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emergencyroom;

/**
 *
 * @author es.carlsten
 */
public interface ITreatmentRoomManager {
    
    public void assignPatient(Patient patient);
    
    public void unassignPatient(Patient patient);
    
    public boolean hasRoomAvailable();
    
}
