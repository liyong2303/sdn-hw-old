package com.ky.aspect;
/*
 * 切换数据源（不同方法调用不同数据源）
 *作者：barret
 *日期：2018年2月1日
 *
*/

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;



@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DataSourceAspect {
	protected Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);
	
	@Pointcut("execution(* com.ky.dao.*.*(..))")
	public void aspect(){
	}
	
	@Before("aspect()")
	public void before(JoinPoint point){
		String className = point.getTarget().getClass().getName();
        String method = point.getSignature().getName();
        logger.info(className + "." + method + "(" + StringUtils.join(point.getArgs(), ",") + ")");
        try {
            for (String key : ChooseDataSource.METHOD_TYPE_MAP.keySet()) {
                for (String type : ChooseDataSource.METHOD_TYPE_MAP.get(key)) {
                    if (method.startsWith(type)) {
                    	logger.info("datasource:"+key);
                        DataSourceHandler.putDataSource(key);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
