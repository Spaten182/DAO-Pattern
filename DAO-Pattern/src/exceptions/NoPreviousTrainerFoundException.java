/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Jaqueline
 */
public class NoPreviousTrainerFoundException extends Exception {
    public NoPreviousTrainerFoundException(String message)
    {
        super(message);
    }
    
    public NoPreviousTrainerFoundException(Throwable cause) 
    {
        super(cause);
    }

    public NoPreviousTrainerFoundException(String message, Throwable cause)
    {
        super(message, cause);        
    }
   
}
