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
public class NoNextTrainerFoundException extends Exception {
    public NoNextTrainerFoundException(String message)
    {
        super(message);
    }
    
    public NoNextTrainerFoundException(Throwable cause) 
    {
        super(cause);
    }

    public NoNextTrainerFoundException(String message, Throwable cause)
    {
        super(message, cause);        
    }
    
}
