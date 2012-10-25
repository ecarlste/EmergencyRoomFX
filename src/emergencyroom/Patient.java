/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emergencyroom;

/**
 *
 * @author es.carlsten
 */
public class Patient {
    
    private int    id;
    private String firstName;
    private String lastName;
    private String middleInitial;
    private int    socialSecurityNumber;
    private int    priority;
    
    public Patient(int id)
    {
        this.id = id;
    }
    
    public Patient(int id, int priority)
    {
        this(id);
        
        this.priority = priority;
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public String getLastName()
    {
        return lastName;
    }
    
    public void setMiddleInitial(String middleInitial)
    {
        this.middleInitial = middleInitial;
    }
    public String getMiddleInitial()
    {
        return middleInitial;
    }
    
    public void setSocialSecurityNumber(int socialSecurityNumber)
    {
        this.socialSecurityNumber = socialSecurityNumber;
    }
    public int getSocialSecurityNumber()
    {
        return socialSecurityNumber;
    }
    
    public void setPriority(int priority)
    {
        this.priority = priority;
    }
    public int getPriority()
    {
        return priority;
    }
    
}
