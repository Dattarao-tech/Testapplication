package com.springboot.web.security.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.springboot.web.security.Entity.ColorInfo;
import com.springboot.web.security.Entity.ColorList;
import com.springboot.web.security.Entity.ColorListNew;
import com.springboot.web.security.Service.ColorService;

import ch.qos.logback.core.subst.Token.Type;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/co")
public class ColorController {
	
	@Autowired
	private  ColorService  colorService;  
	
	
	@PostMapping("/processColors") 
    public void processColors(@RequestBody ColorInfo myReqeust) throws JsonProcessingException {
		//System.out.println("mystring " +  myReqeust.toString());     
       //System.out.println("mycolor " + myReqeust.toString());
		
	
		ObjectMapper mapper = new ObjectMapper();
		String writeValueAsString = mapper.writeValueAsString(mapper);
//		List<String> primaryColore=new ArrayList<>();
//		List<String> secoundryColore=new ArrayList<>();
//		List<String> noneColore=new ArrayList<>();
		
//		ColorListNew[] colorPara = myReqeust.getColors();
		
		
//		for(int i=0; i<colorPara.length; ++i)
//
//       System.out.println("primary:"+colorPara[i]);  
//		for(ColorListNew colore :colorPara) {
//			if("primary".equals(colore.getType())) {
//				primaryColore.add(colore.getColor());
//			}else if("secondary".equals(colore.getType())) {
//				secoundryColore.add(colore.getColor());
//			}
//			else {
//				noneColore.add(colore.getColor());
//			}
//		}
//		System.out.println("Primary :"+primaryColore);
//		System.out.println("secound:"+secoundryColore);
//		System.out.println("None"+noneColore);
//	
//		HashMap<String, List<String>> hd = new HashMap<>();
//		hd.put("Primary ", Arrays.asList("black, blue, yellow, green"));
		

        ColorListNew[] colorPara = myReqeust.getColors();
        Map<String, List<String>> colorMap = new HashMap<>();
        for (ColorListNew color : colorPara) {
        
            String type = color.getType();
            String colorValue = color.getColor();
            colorMap.putIfAbsent(type, new ArrayList<>());
            colorMap.get(type).add(colorValue);
            
        }
        for (Map.Entry<String, List<String>> entry : colorMap.entrySet()) {
            String type = entry.getKey();
            List<String> colors = entry.getValue();
            System.out.println(type + ": " + colors);
        }
    }
}      
