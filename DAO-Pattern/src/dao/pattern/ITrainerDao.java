/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.pattern;

/**
 *
 * @author Hendrik
 */
public interface ITrainerDao {
    public ITrainer create();
    public void delete(ITrainer trainer);
    public ITrainer first();
    public ITrainer last();
    public ITrainer next(ITrainer trainer);
    public ITrainer previous(ITrainer trainer);
    public void save (ITrainer trainer);
    public List<ITrainer> select();
    public ITrainer select(int id);
}
