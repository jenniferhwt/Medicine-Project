package com.rippletec.medicine.utils;

public class StringUtil {
    
    /**获取hql语句
     * @param Name PO类名
     * @param params 参数名
     * @return 返回实例 from Enterprise q where q.type=:type and q.phone=:phone 
     */
    public static String getSelectHql(String Name, String[] params) {
	String hql = "from "+Name;
	if(params == null || params.length == 0)
	    return hql;
	hql += " q where ";
	for (int i = 0; i < params.length; i++) {
	    String param = params[i];
	    hql += "q."+param+"=:"+param+" and ";
	}
	hql = hql.substring(0, hql.length()-4);
	return hql;
    }
    
    public static String getSelectHql(String Name, String param) {
	return getSelectHql(Name, new String[]{param});
    }
    
    public static String getSelectHql(String Name) {
	return getSelectHql(Name, new String[]{});
    }
   

}
