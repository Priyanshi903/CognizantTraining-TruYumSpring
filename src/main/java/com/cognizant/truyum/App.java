package com.cognizant.truyum;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.model.MenuItem;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        MenuItem m= (MenuItem) ctx.getBean("sandwich");
        System.out.println(m.getDateOfLaunch());
    }
}
