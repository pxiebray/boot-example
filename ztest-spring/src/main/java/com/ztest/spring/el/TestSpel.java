package com.ztest.spring.el;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/7/31 0031 47
 */
public class TestSpel {

    public static void main(String[] args) {
        Inventor inventor = new Inventor("hello", 10);

        //方法调用
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("getName()");
        System.out.println(expression.getValue(inventor, String.class));

        parser.parseExpression("setAge(11)").getValue(inventor);
        System.out.println(inventor.getAge());
    }

    public static class Inventor {
        protected String name;
        protected int age;

        public Inventor(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
