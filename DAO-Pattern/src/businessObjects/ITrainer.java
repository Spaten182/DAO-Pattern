/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessObjects;

/**
 *
 * @author nils743
 */
public interface ITrainer {


// Getter
public int getId();
public String getName();
public int getAlter();
public int getErfahrung();

// Setter
public void setName(String name);
public void setAlter (int alter);
public void setErfahrung (int erfahrung);

}
