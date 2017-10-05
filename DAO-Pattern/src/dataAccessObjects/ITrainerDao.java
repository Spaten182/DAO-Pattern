/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessObjects;

import businessObjects.*;
import exceptions.*;
import java.util.List;

/**
 *
 * @author Hendrik
 */
public interface ITrainerDao {
    public ITrainer create();
    public void delete(ITrainer trainer);
    public ITrainer first() throws NoTrainerFoundException;
    public ITrainer last() throws NoTrainerFoundException;
    public ITrainer next(ITrainer trainer) throws NoNextTrainerFoundException;
    public ITrainer previous(ITrainer trainer) throws NoPreviousTrainerFoundException;
    public void save (ITrainer trainer);
    public List<ITrainer> select() throws NoTrainerFoundException;
    public ITrainer select(int id) throws NoTrainerFoundException;
}
