package com.ssi;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestController {

	@RequestMapping("entryform")
	public String showEntryForm(){
		return "details.jsp";
	}
	@RequestMapping("Calculate")
	public ModelAndView process(@RequestParam("t1") int amount, @RequestParam("t2") int time, HttpServletResponse response){
		
		int si=(amount*time*10)/100;
		ModelAndView mv=new ModelAndView();
		mv.setViewName("result.jsp");
		mv.addObject("amountvalue", amount);
		mv.addObject("timevalue",time);
		mv.addObject("interestvalue", si);
		return mv;
	}
	/*
	@RequestMapping("Calculate")
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response){
		
		int amount=Integer.parseInt(request.getParameter("t1"));
		int time=Integer.parseInt(request.getParameter("t2"));
		
		int si=(amount*time*10)/100;
		
	
		ModelAndView mv=new ModelAndView();
		mv.setViewName("result.jsp");
		mv.addObject("amountvalue", amount);
		mv.addObject("timevalue",time);
		mv.addObject("interestvalue", si);
		
		try {
			PrintWriter out=response.getWriter();
			out.println("Thanks For Using Our Services");
			out.println("Amount : "+amount);
			out.println("Time  : "+time);
			out.println("Interest : "+si);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return mv;
		
	}
	*/
}
