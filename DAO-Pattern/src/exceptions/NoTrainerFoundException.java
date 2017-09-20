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
public class NoTrainerFoundException extends Exception{
    public NoTrainerFoundException(String message)
    {
        super(message);
    }
    
    public NoTrainerFoundException(Throwable cause) 
    {
        super(cause);
    }

    public NoTrainerFoundException(String message, Throwable cause)
    {
        super(message, cause);        
    }
   
}
