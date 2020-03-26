package com.landonhotel.eventsapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	@GetMapping(path = "/quoteRequests/{quoteId}", params = "eventType")
	public String viewQuoteRequest(@PathVariable int quoteId) {
		
		// refer quoteId
		return "quoteRequestDetails";
	}
	@PostMapping("/quoteDetail")
	public String updateQuoteRequest(@ModelAttribute QuoteRequest formBean) {
		//implement a save of all of the form bean information
		
		return "quoteRequestDetails";
	}

}
