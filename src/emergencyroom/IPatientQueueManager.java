/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emergencyroom;

/**
 *
 * @author es.carlsten
 */
public interface IPatientQueueManager {

    public void insertPatient(Patient patient);
    
    public Patient removePatient();
    
}
