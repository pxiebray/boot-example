package com.ztest.boot.mvc.common.statistics;

import com.ztest.boot.mvc.common.Statistics;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author xiepeng
 * @version 1.0
 * @data 2018/7/13 0013 45
 */
@Component
@Aspect
public class StatisticsAspect {

    /**
     * execution(* com.savage.cache.MessageSender.*(..))
     * args()
     * @args()
     * execution()
     * this()
     * target()
     * @target()    目标类型，继承有效
     * within()
     * @within()    目标类，继承无效
     * @annotation  方法上的注解
     */
    @Pointcut(value = "execution(* com.ztest..*.*(..))")
    public void statisticsPointcut() {}

    /**
     * 前置通知(获取输入参数)
     * 第一个参数为切入点的名称,
     * 第二个是限定方法注解，参数名称与方法中的名称相同，用来取输入参数，可以不要
     *
     * @param point
     * @param statistics
     */
    @Before("statisticsPointcut() && @annotation(statistics)")
    public void before(JoinPoint point, Statistics statistics) {
//        System.out.println("@Statics：目标type为：" + point.getSignature().getDeclaringTypeName());
//        System.out.println("@Statics：目标method为：" + point.getSignature().getName());
//        System.out.println("@Statics：参数为：" + Arrays.toString(point.getArgs()));
//        System.out.println("@Statics：被织入的目标对象为：" + point.getTarget());

        SpelExpressionParser expressionParser = new SpelExpressionParser();
        SpelExpression spelExpression = expressionParser.parseRaw(statistics.value());
        Integer str = (Integer) spelExpression.getValue(point);
    }
}
