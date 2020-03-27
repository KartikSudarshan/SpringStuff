package com.landonhotel.eventsapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.landonhotel.eventsapp.domain.QuoteRequest;

@Controller
public class QuoteRequestManagementController {

	@GetMapping(path = "/quoteRequests")
	public String listRequests() {
		return "quoteRequestList";
	}

	@GetMapping(path = "/quoteRequests", params = "eventType")
	public String listWeddingRequests() {
		return "quoteRequestList";
	}

	@GetMapping(path = "/quoteRequests/{quoteId}")
	public ModelAndView viewQuoteRequest(@PathVariable int quoteId) {

		QuoteRequest quoteRequestBean = new QuoteRequest();
		quoteRequestBean.setBudget(5000);
		quoteRequestBean.setEventType("wedding");
		ModelAndView mav = new ModelAndView();
		mav.addObject("quoteRequestBean", quoteRequestBean);
		mav.setViewName("quoteRequestDetails");
		return mav;
	}

	
	@GetMapping(path = "/quoteRequests/social/{id}")
	public String viewRequestSocial(@PathVariable int id) {
		String returnViewName="quoteRequestSocialEventDetailPage";
		boolean someCondition=true;
		if (someCondition)
			returnViewName="redirect:/quoteRequest/wedding/{id}";
		
		return returnViewName;
		
	}
	
	@GetMapping(path = "/quoteRequests/social/{id}")
	@ResponseBody
	public QuoteRequest viewQuoteRequestApi(@PathVariable int id) {
		QuoteRequest quoteRequest=new QuoteRequest();
		return quoteRequest;
		
	}
	
	@PostMapping("/quoteDetail")
	public String updateQuoteRequest(@ModelAttribute QuoteRequest formBean) {
		// implement a save of all of the form bean information

		return "quoteRequestDetails";
	}

}
