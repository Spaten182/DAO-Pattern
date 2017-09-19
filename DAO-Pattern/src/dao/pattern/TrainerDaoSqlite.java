/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.pattern;

import java.util.List;

/**
 *
 * @author Hendrik
 */
public class TrainerDaoSqlite implements ITrainerDao {
    private String CLASSNAME;
    private String CONNECTIONSTRING;
    
    public ITrainer create() {
        ITrainer trainer = new ITrainer();
        return trainer;
    }
    
    public void delete(ITrainer trainer) {
        
    }
    
    public ITrainer first() {
        
    }
    
    public ITrainer last() {
        
    }
    
    public ITrainer next(ITrainer trainer) {
        TrainerDaoSqlite TDS = new TrainerDaoSqlite();
        List<ITrainer> liste = TDS.select();
        
        for(int n = 0; n < liste.length(); n++) {
            if (liste.get(n) == trainer) {
                return liste.get(n+1);
            }
        }
        throw new NoNextTrainerFoundException();
    }
    
    public ITrainer previous(ITrainer trainer) {
        TrainerDaoSqlite TDS = new TrainerDaoSqlite();
        List<ITrainer> liste = TDS.select();
        
        for(int n = 0; n < liste.length(); n++) {
            if (liste.get(n) == trainer) {
                return liste.get(n-1);
            }
        }
        throw new NoPreviousTrainerFoundException();
    }
    
    public void save(ITrainer trainer) {
        
    }
    
    public List<ITrainer> select() {
        
    }
    
    public ITrainer select(int id) {
        
    }
}
