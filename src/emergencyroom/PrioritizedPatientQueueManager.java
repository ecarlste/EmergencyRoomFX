/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emergencyroom;

import java.util.LinkedList;
import java.util.ListIterator;
import queue.Queue;

/**
 *
 * @author es.carlsten
 */
public class PrioritizedPatientQueueManager implements IPatientQueueManager
{
    
    private LinkedList<Queue<Patient>> patientQueues;
    
    public PrioritizedPatientQueueManager(int priorityCount)
    {
        patientQueues = new LinkedList<>();
        
        for (int i = 0; i < priorityCount; i++)
        {
            patientQueues.add(new Queue<Patient>());
        }
    }
    
    @Override
    public void insertPatient(Patient patient)
    {
        patientQueues.get(patient.getPriority()-1).insert(patient);
    }
    
    @Override
    public Patient removePatient()
    {
        ListIterator<Queue<Patient>> iter = patientQueues.listIterator();
        Queue<Patient> queue;
        
        while (iter.hasNext())
        {
            queue = iter.next();
            
            if (!queue.isEmpty())
            {
                return queue.remove();
            }
        }
        
        return null;
    }
    
}
