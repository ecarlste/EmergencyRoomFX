/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emergencyroom;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 *
 * @author es.carlsten
 */
public class MultipleTreatmentRoomManager implements ITreatmentRoomManager
{
    
    private LinkedList<TreatmentRoom> treatmentRooms;
    private int treatmentRoomCount;
    private int patientCount;
    
    public MultipleTreatmentRoomManager(int treatmentRoomCount)
    {
        this.treatmentRoomCount = treatmentRoomCount;
        patientCount = 0;
        treatmentRooms = new LinkedList<>();
        
        for (int i = 0; i < treatmentRoomCount; i++)
        {
            treatmentRooms.add(new TreatmentRoom());
        }
    }
    
    @Override
    public void assignPatient(Patient patient)
    {
        ListIterator<TreatmentRoom> iter = treatmentRooms.listIterator();
        TreatmentRoom currentRoom;
        
        do
        {
            currentRoom = iter.next();
        } while (currentRoom.getPatient() != null);
        
        patientCount++;
        currentRoom.setPatient(patient);
    }
    
    @Override
    public void unassignPatient(Patient patient)
    {
        TreatmentRoom room = findPatient(patient);
        
        if (room != null)
        {
            room.removePatient();
            patientCount--;
        }
        else
        {
            throw new NoSuchElementException("The requested patient does not exist.");
        }
    }
    
    @Override
    public boolean hasRoomAvailable()
    {
        return patientCount < treatmentRoomCount;
    }
    
    private TreatmentRoom findPatient(Patient patient)
    {
        ListIterator<TreatmentRoom> iter = treatmentRooms.listIterator();
        TreatmentRoom room;
        
        while (iter.hasNext())
        {
            room = iter.next();
            
            if (room.getPatient() == patient)
            {
                return room;
            }
        }
        
        return null;
    }
    
}
