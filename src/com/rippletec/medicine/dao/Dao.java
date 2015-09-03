/**
 * 
 */
package com.rippletec.medicine.dao;

/**
 * @author Liuyi
 *
 */
public interface Dao <T>{
    
    /**
     * Dao层基础save()方法
     * @param model 需要持久化的实体
     * @return id
     */
    public Integer save(T model);
    
    /**
     * Dao层基础delete()方法
     * @param id 需要删除条目的id
     */
    public void delete(Integer id);
    
    /**
     * Dao层基础update方法
     * @param model 更新实体
     */
    public void update(T model);
    
    /**
     * Dao层基础find方法
     * @param id 条目id
     * @return 
     */
    public T find(Integer id);

}
