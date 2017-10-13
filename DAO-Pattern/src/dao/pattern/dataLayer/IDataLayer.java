package dao.pattern.dataLayer;

import dataAccessObjects.ITrainerDao;

/**
 * @author Kevin
 */
public interface IDataLayer {
    
    ITrainerDao getTrainerDao();
    
}
