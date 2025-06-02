package Exampledemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo12 {
	
	@Value("${my.greeting}")
	private String geetingmessage;
	
	@RequestMapping("/demo")
	public String get() {
		return geetingmessage;
	}
}
