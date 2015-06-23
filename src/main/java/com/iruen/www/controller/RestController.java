package com.iruen.www.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestController {
	
	private static final Logger logger = LoggerFactory.getLogger(RestController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "hello";
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello(ModelMap model) {
		System.out.println("hello URL");
		model.addAttribute("msg", "OracleJava Community Spring4");
		return "hello";
	}
	
	//아래 hi 메소드로 들어오는 인자값은 URL경로의일부로 넘겨줘야 한다.
	@RequestMapping(value="/hi/{msg}", method=RequestMethod.GET)
	public String hi(@PathVariable String msg, ModelMap model) {
		System.out.println("hi URL");
		model.addAttribute("msg",msg);
		return "hello";
	}	
}
