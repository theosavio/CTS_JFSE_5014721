package com.theo.LibraryManagement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; 

import com.library.service.BookService;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
    	
    	BookService bookService=(BookService) context.getBean("bookservice");
    	
    	bookService.manageBooks();
    	
    	
    }
}
