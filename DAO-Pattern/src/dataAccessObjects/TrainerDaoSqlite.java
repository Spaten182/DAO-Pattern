/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessObjects;

import java.util.List;
import businessObjects.*;
import exceptions.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hendrik
 */
public class TrainerDaoSqlite implements ITrainerDao {
    private String CLASSNAME = "org.sqlite.JDBC";
    private String CONNECTIONSTRING = "jdbc:sqlite:databases/trainer.db";
    
    @Override
    public ITrainer create()
    {
        ITrainer trainer = new Trainer();
        return trainer;
    }
    
    @Override
    public void delete(ITrainer trainer)
    {
        try
        {
            Class.forName(CLASSNAME);
            Connection conn = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "DELETE FROM trainer WHERE rowid = ? AND name = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, trainer.getId());
            statement.setString(2, trainer.getName());
            statement.executeUpdate();
        }
        catch (Exception e)
        {
        }
    }
    
    @Override
    public ITrainer first() throws NoTrainerFoundException
    {
        try
        {
            Class.forName(CLASSNAME);
            Connection conn = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "SELECT ROWID, * FROM trainer WHERE rowid = 1";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = null;
            resultSet = statement.executeQuery();
            
            if(!resultSet.isBeforeFirst())
            {
                throw new NoTrainerFoundException("Database is empty.");
            }
            else
            {
                Trainer trainer = new Trainer();
                trainer.setId(resultSet.getInt("rowid"));
                trainer.setName(resultSet.getString("name"));
                trainer.setAlter(resultSet.getInt("alter"));
                trainer.setErfahrung(resultSet.getInt("erfahrung"));
                return trainer;
            }
        }
        catch (SQLException | ClassNotFoundException e)
        {
        }
        return null;
    }
    
    @Override
    public ITrainer last() throws NoTrainerFoundException
    {
        try
        {
            Class.forName(CLASSNAME);
            Connection conn = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "SELECT ROWID, * FROM trainer WHERE rowid = 1";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = null;
            resultSet = statement.executeQuery();
            
            if(!resultSet.isBeforeFirst())
            {
                throw new NoTrainerFoundException("Database is empty.");
            }
            else
            {
                while(resultSet.next());
                resultSet.previous();
                Trainer trainer = new Trainer();
                trainer.setId(resultSet.getInt("rowid"));
                trainer.setName(resultSet.getString("name"));
                trainer.setAlter(resultSet.getInt("alter"));
                trainer.setErfahrung(resultSet.getInt("erfahrung"));
                return trainer;
            }
        }
        catch (SQLException | ClassNotFoundException e)
        {
        }
        return null;
    }
    
    @Override
    public ITrainer next(ITrainer trainer) throws NoNextTrainerFoundException
    {
        try
        {
            Class.forName(CLASSNAME);
            Connection conn = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "SELECT ROWID, * FROM trainer WHERE rowid = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, trainer.getId()+1);
            ResultSet resultSet = null;
            resultSet = statement.executeQuery();
            
            if(!resultSet.isBeforeFirst())
            {
                throw new NoNextTrainerFoundException("No next Trainer found.");
            }
            else
            {
                Trainer Ntrainer = new Trainer();
                Ntrainer.setId(resultSet.getInt("rowid"));
                Ntrainer.setName(resultSet.getString("name"));
                Ntrainer.setAlter(resultSet.getInt("alter"));
                Ntrainer.setErfahrung(resultSet.getInt("erfahrung"));
                return Ntrainer;
            }
        }
        catch (SQLException | ClassNotFoundException e)
        {
        }
        return null;
    }
    
    @Override
    public ITrainer previous(ITrainer trainer) throws NoPreviousTrainerFoundException
    {
        try
        {
            Class.forName(CLASSNAME);
            Connection conn = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "SELECT ROWID, * FROM trainer WHERE rowid = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, trainer.getId()-1);
            ResultSet resultSet = null;
            resultSet = statement.executeQuery();
            
            if(!resultSet.isBeforeFirst())
            {
                throw new NoPreviousTrainerFoundException("No previous Trainer found.");
            }
            else
            {
                Trainer Ptrainer = new Trainer();
                Ptrainer.setId(resultSet.getInt("rowid"));
                Ptrainer.setName(resultSet.getString("name"));
                Ptrainer.setAlter(resultSet.getInt("alter"));
                Ptrainer.setErfahrung(resultSet.getInt("erfahrung"));
                return Ptrainer;
            }
        }
        catch (SQLException | ClassNotFoundException e)
        {
        }
        return null;
    }
    
    @Override
    public void save(ITrainer trainer)
    {
        try
        {
            Class.forName(CLASSNAME);
            Connection conn = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "INSERT INTO trainer (name, 'alter', erfahrung) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, trainer.getName());
            statement.setInt(2, trainer.getAlter());
            statement.setInt(3, trainer.getErfahrung());
            statement.executeUpdate();
        }
        catch (Exception e)
        {
        }
    }
    
    @Override
    public List<ITrainer> select() throws NoTrainerFoundException
    {
        try
        {
            Class.forName(CLASSNAME);
            Connection conn = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "SELECT ROWID, * FROM trainer";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = null;
            resultSet = statement.executeQuery();
            
            if(!resultSet.isBeforeFirst())
            {
                throw new NoTrainerFoundException("Database is empty.");
            }
            else
            {
                List<ITrainer> trainerList = new ArrayList<ITrainer>();
            
                resultSet.previous();
                while(resultSet.next())
                {
                    Trainer trainer = new Trainer();
                    trainer.setId(resultSet.getInt("rowid"));
                    trainer.setName(resultSet.getString("name"));
                    trainer.setAlter(resultSet.getInt("alter"));
                    trainer.setErfahrung(resultSet.getInt("erfahrung"));
                    trainerList.add(trainer);
                }
                return trainerList;
            }
        }
        catch (SQLException | ClassNotFoundException e)
        {
        }
        return null;
    }
    
    @Override
    public ITrainer select(int id) throws NoTrainerFoundException
    {
        try
        {
            Class.forName(CLASSNAME);
            Connection conn = DriverManager.getConnection(CONNECTIONSTRING);
            String sql = "SELECT ROWID, * FROM trainer WHERE rowid = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = null;
            resultSet = statement.executeQuery();
            
            if(!resultSet.isBeforeFirst())
            {
                throw new NoTrainerFoundException("No Trainer with that ID exists.");
            }
            else
            {
                Trainer trainer = new Trainer();
                trainer.setId(resultSet.getInt("rowid"));
                trainer.setName(resultSet.getString("name"));
                trainer.setAlter(resultSet.getInt("alter"));
                trainer.setErfahrung(resultSet.getInt("erfahrung"));
                return trainer;
            }
        }
        catch (SQLException | ClassNotFoundException e)
        {
        }
        return null;
    }
}
