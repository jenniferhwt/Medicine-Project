package com.rippletec.medicine.dao;

import java.util.List;
import java.util.Map;

import com.rippletec.medicine.bean.PageBean;

/**
 * @author Liuyi
 * 分页查询接口，提供分页查询功能
 * @param <T>
 */
public interface IFindByPage<T> {
    
    /**
     * 基本分页查找方法
     * @param page offset,pageSize字段不能为空
     * @return
     */
    public List<T> findByPage(PageBean page);
    
    /**
     * 单参数分页查找
     * @param param 参数名
     * @param value 参数值
     * @param page offset,pageSize字段不能为空
     * @return
     */
    public List<T> findByPage(String param, Object value, PageBean page);
    
    /**
     * 多参数分页查找
     * @param paramMap 格式为：<参数名，参数值>
     * @param page offset,pageSize字段不能为空
     * @return
     */
    public List<T> findByPage(Map<String, Object> paramMap, PageBean page);
}
