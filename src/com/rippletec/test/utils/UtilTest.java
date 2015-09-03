package com.rippletec.test.utils;

import org.junit.Test;

import com.rippletec.medicine.model.Enterprise;
import com.rippletec.medicine.utils.StringUtil;

public class UtilTest {
    
    @Test
    public void testStringUttil() throws Exception {
	System.out.println(StringUtil.getSelectHql(Enterprise.CLASS_NAME));
	System.out.println(StringUtil.getSelectHql(Enterprise.CLASS_NAME, new String[]{}));
	System.out.println(StringUtil.getSelectHql(Enterprise.CLASS_NAME, new String[]{Enterprise.TYPE}));
	System.out.println(StringUtil.getSelectHql(Enterprise.CLASS_NAME, new String[]{Enterprise.TYPE,Enterprise.PHONE}));
    }

}
