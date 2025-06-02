package com.springboot.web.security.Service;

import java.util.List;

import com.springboot.web.security.Entity.ColorInfo;
import com.springboot.web.security.Entity.ColorList;

public interface ColorService {
	
	 void processColors(ColorList colorList);
}
