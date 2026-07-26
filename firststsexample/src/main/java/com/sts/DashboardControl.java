package com.sts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sts.topic.SingleService;
import com.sts.topic.StockSingle;

@Controller
public class DashboardControl {
	
		
	   @Autowired
	    private SingleService singleService;

	    private final List<String> chatHistory = new java.util.ArrayList<>();

	    @GetMapping("/dashboard")
	    public String showDashboard(Model model) {
	        List<StockSingle> signals = singleService.getSingle();
	        model.addAttribute("signals", signals);

	        String chatHtml = String.join("<br/>", chatHistory);
	        model.addAttribute("chathistory", chatHtml);

	        return "dashboard";
	    }

	    @PostMapping("/chat")
	    public String handleChat(@RequestParam("userMessage") String userMessage) {
	        chatHistory.add("<b>You:</b> " + userMessage);
	        chatHistory.add("<b>Bot:</b> I received your message: " + userMessage);
	        return "redirect:/dashboard";
	    }
	
}

