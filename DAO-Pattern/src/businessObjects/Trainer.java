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
public class Trainer implements ITrainer {

    // Attribute
    private int id;
    private String name;
    private int alter;
    private int erfahrung;
    
    // Konstruktor
    public Trainer() {}
   
    // Getter und Setter
    public void setId(int id) {
        this.id = id;
    }
    
    // Overrides
    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAlter() {
        return this.alter;
    }

    @Override
    public int getErfahrung() {
        return this.erfahrung;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setAlter(int alter) {
        this.alter = alter;
    }

    @Override
    public void setErfahrung(int erfahrung) {
        this.erfahrung = erfahrung;
    }
    
}
