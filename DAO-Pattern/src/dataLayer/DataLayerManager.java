/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataLayer;
package settings;

/**
 *
 * @author nils743
 */
public class DataLayerManager {

    // Attribute
    private static DataLayerManager instance;
    
    // Konstruktor
    private DataLayerManager() {
        // Hier Quellcode einfügen
    }
    
    // Getter und Setter
    public DataLayerManager getInstance() {
        if (instance == null) {
            instance = new DataLayerManager();
        }
        return instance;
    }
    
    public IDataLayer getDataLayer() {
        // Hier muss eine Auswahl aus den Settings gelesen werden
        // Ob XML oder SQLite Daten verwendet werden sollen
        return null; // Eig. Objekt übergeben
    }
    
}
