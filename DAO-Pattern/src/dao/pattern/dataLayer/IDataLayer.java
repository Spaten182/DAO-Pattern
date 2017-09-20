package dao.pattern.dataLayer;

import dao.pattern.dataLayer.ITrainerDao;

/**
 * @author Kevin
 */
public interface IDataLayer {
    
    ITrainerDao getTrainerDao();
    
}
