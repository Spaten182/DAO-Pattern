/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessObjects;

import java.util.List;
import businessObjects.*;
import exceptions.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Hendrik
 */
public class TrainerDaoSqlite implements ITrainerDao {
    private String CLASSNAME = "org.sqlite.JDBC";
    private String CONNECTIONSTRING = "jdbc:sqlite:DAO-Pattern/databases/trainer.db";
    
    @Override
    public ITrainer create() {
        ITrainer trainer = new Trainer();
        return trainer;
    }
    
    @Override
    public void delete(ITrainer trainer) {
        try {
            Class.forName(CLASSNAME);
            Connection conn = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "DELETE FROM trainer WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, trainer.getId());
            statement.executeUpdate();
        }
        catch (Exception e) {
            
        }
    }
    
    @Override
    public ITrainer first() {
        try {
            Class.forName(CLASSNAME);
            Connection conn = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "SELECT ROWID, * FROM trainer WHERE rowid = 1";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            // TODO: convert string to trainer object
        }
        catch (Exception e) {
            
        }
        /*
        TrainerDaoSqlite TDS = new TrainerDaoSqlite();
        List<ITrainer> liste = TDS.select();
        
        return liste.get(0);
        */
    }
    
    @Override
    public ITrainer last() {
        TrainerDaoSqlite TDS = new TrainerDaoSqlite();
        List<ITrainer> liste = TDS.select();
        
        return liste.get(liste.size()-1);
    }
    
    @Override
    public ITrainer next(ITrainer trainer) {
        try {
            TrainerDaoSqlite TDS = new TrainerDaoSqlite();
            List<ITrainer> liste = TDS.select();
            
            for(int n = 0; n < liste.size(); n++) {
                if (liste.get(n) == trainer) {
                    return liste.get(n+1);
                }
            }
            throw new NoNextTrainerFoundException("No next trainer found!");
        } catch (NoNextTrainerFoundException ex) {
            Logger.getLogger(TrainerDaoSqlite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public ITrainer previous(ITrainer trainer) {
        try {
            TrainerDaoSqlite TDS = new TrainerDaoSqlite();
            List<ITrainer> liste = TDS.select();
            
            for(int n = 0; n < liste.size(); n++) {
                if (liste.get(n) == trainer) {
                    return liste.get(n-1);
                }
            }
            throw new NoPreviousTrainerFoundException("No previous trainer found!");
        } catch (NoPreviousTrainerFoundException ex) {
            Logger.getLogger(TrainerDaoSqlite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public void save(ITrainer trainer) {
        try {
            Class.forName(CLASSNAME);
            Connection conn = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "INSERT INTO trainer (name, 'alter', erfahrung) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, trainer.getName());
            statement.setInt(2, trainer.getAlter());
            statement.setInt(3, trainer.getErfahrung());
            statement.executeUpdate();
        }
        catch (Exception e) {
            
        }
    }
    
    @Override
    public List<ITrainer> select() {
        try {
            Class.forName(CLASSNAME);
            
            Connection conn = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "SELECT ROWID, * FROM trainer";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            // TODO: convert resultSet string to List<ITrainer>
        }
        catch (Exception e) {
            Logger.getLogger(TrainerDaoSqlite.class.getName()).log(Level.SEVERE, null, e);
        }

        return null;
    }
    
    @Override
    public ITrainer select(int id) {
        try {
            Connection conn = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "SELECT ROWID, * FROM trainer WHERE rowid = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            // TODO: convert resultSet string to trainer object
        }
        catch (Exception e) {
            
        }
    }
}
