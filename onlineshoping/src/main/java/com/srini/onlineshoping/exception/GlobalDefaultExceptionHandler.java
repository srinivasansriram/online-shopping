package com.srini.onlineshoping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice

public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() 
	
	{
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("errorTitle", "the page is not constructed yet !!!!!!");
			mv.addObject("errorDescription", "the page is not available at the moment try again later!!!!!!");
			
			mv.addObject("title","404 Error Page");
			
			return mv;
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() 
	
	{
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("errorTitle", "Sorry no product available now  !!!!!!");
			mv.addObject("errorDescription", "the product is not available at the moment try again later!!!!!!");
			
			mv.addObject("title","Product not available");
			
			return mv;
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex ) 
	
	{
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("errorTitle", "contact your administrator  !!!!!!");
			
			
			
			/* only for debugging of our code*/
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			
			ex.printStackTrace(pw);
			mv.addObject("errorDescription", sw.toString());
			
			mv.addObject("title","Error");
			
			return mv;
	}

	
}