/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settings;

/**
 *
 * @author Jaqueline
 */
public class SettingsManager {
    
    private SettingsManager instance;
    private PersistenceSettings persistenceSettings;
    
    public SettingsManager(){};
    
    public SettingsManager getInstance()
    {
        if(instance==null) 
        {
            instance = new SettingsManager();
        }
        return instance;
    }
    
    public PersistenceSettings getPersistenceSettings()
    {
        return persistenceSettings;
    }
    
    private PersistenceSettings readPersistenceSettings()
    {
        //einlesen aus xml und setzen, wird nach xml-Datei implementiert
        return null;
    }
}
