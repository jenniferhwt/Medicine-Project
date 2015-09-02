package com.rippletec.medicine.support;

import java.util.List;

import com.rippletec.medicine.bean.PageBean;
import com.rippletec.medicine.model.BaseModel;

/**
 * @author Liuyi
 * 分页查询接口，提供分页查询功能
 */
public interface IFindByPage {
    
    //基本分页查询
    public List<BaseModel> findByPage(final String hql, PageBean page);
}
