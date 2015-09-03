/**
 * 
 */
package com.rippletec.medicine.dao;

import com.rippletec.medicine.model.BaseModel;

/**
 * @author Liuyi
 *
 */
public interface Dao {
    
    public Integer save(BaseModel model);
    
    public void delete(Integer id);
    
    public void update(BaseModel model);
    
    public BaseModel find(Integer id);

}
