/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataLayer;
import settings.*;

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
        SettingsManager sm = new SettingsManager();
        sm = sm.getInstance();
        
        PersistenceSettings ps = new PersistenceSettings();
        ps = sm.getPersistenceSettings();
        
        String type = ps.getPersistennceType();
        
        if (type == "xml" ) {
            DataLayerXML dlxml = new DataLayerXML();
            return dlxml;
        }
        // else Fehler = nicht gefunden = abfangen!
            
        if (type == "sqlite" ) {
            DataLayerSqlite dlsqlite = new DataLayerSqlite();
            return dlsqlite;
        }
        // else Fehler = nicht gefunden = abfangen!
    }
    
}
