package com.springboot.web.security.ServiceImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.springboot.web.security.Entity.ColorCode;
import com.springboot.web.security.Entity.ColorInfo;
import com.springboot.web.security.Entity.ColorList;
import com.springboot.web.security.Service.ColorService;
@Service
public class ColorServiceImpl implements ColorService{
	@Override
	 public void processColors(ColorList colorList) {
//		 List<ColorInfo> colors = colorList.getColors();
//
//	        for (ColorInfo colorInfo : colors) {
//	            String type = colorInfo.getType();
//	            String category = colorInfo.getCategory();
//	            String colorName = colorInfo.getColor();
//
//	            System.out.println("Color: " + colorName);
//
//	            // Null check for 'type'
//	            if (type != null) {
//	                System.out.println("Type: " + type.toUpperCase());
//
//	                if ("PRIMARY".equals(type) || "SECONDARY".equals(type)) {
//	                    ColorCode code = colorInfo.getCode();
//
//	                    // Null check for 'code'
//	                    if (code != null) {
//	                        List<Integer> rgba = code.getRgba();
//	                        String hex = code.getHex();
//
//	                        System.out.println("RGBA: " + rgba);
//	                        System.out.println("HEX: " + hex);
//	                    }
//	                }
//	            }
//
//	            // Null check for 'category'
//	            if (category != null && "NONE".equals(category)) {
//	                System.out.println("Category: NONE");
//	            }
//	        }
	}
}
