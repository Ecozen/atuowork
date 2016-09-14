package com.test.keydriver.engine;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.TestNGException;

import com.test.data.constance.KeywordReflect;
import com.test.data.constance.ParseKeyword;
import com.test.data.constance.RegisterCenter;
import com.test.utils.TxtUtil;
/**
 * @description 默认关键字执行器
 * @author wenxiang.zheng
 *
 */
public class DefaultExecutor implements Executor{

	static Logger logger = Logger.getLogger(DefaultExecutor.class);
	
	private ParseKeyword pk = new ParseKeyword();
	private List<String> commands;
	public DefaultExecutor(String path){
		commands = TxtUtil.readTxtFile2(path,"utf-8");
		
	}
	@Override
	public void execute(Object...args) {
        for (String command : commands) {
            List<String> keywords = pk.getKeywords(command);
            for (String keyword : keywords) {
                this.invoke(keyword,args);
            }
        }
	}

    public void invoke(String keyword,Object...args){
        Map<String, String> keyMethod = KeywordReflect.KEYWORD_POOLS.get(keyword);
        String className = keyMethod.get("class");
        String methodName = keyMethod.get("method");
        Object obj = RegisterCenter.OBJ_POOLS.get(className);
        Method method = this.getMethod(methodName, obj);
        try {
            method.invoke(obj, args);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
            throw new TestNGException("method invoke failed:"+method.getName(),e);
        }
    }
     
    private Method getMethod(String methodName, Object obj) {
        try {
            Method[] methods = obj.getClass().getMethods();
            for (Method m : methods) {
                if (m.getName().equals(methodName)) {
                    return m;
                }
            }
        } catch (SecurityException e) {
            return null;
        }
        return null;
    }
}
