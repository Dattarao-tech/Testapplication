package com.springboot.web.security.ServiceImp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.springboot.web.security.Entity.Item;
import com.springboot.web.security.Service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	public List<Item> findUniqueParentItems(List<Item> menuItems) {
	    Set<String> parentModules = new HashSet<>();
	    Set<String> childModules = new HashSet<>();
	    List<Item> result = new ArrayList<>();  // Use a mutable list

	    for (Item item : menuItems) {
	        String parentModule = item.getParentModule();
	        String childModule = item.getChildModule();

	        childModules.add(childModule);

	        if (!parentModules.contains(parentModule)) {
	            result.add(new Item(parentModule, childModule));
	            parentModules.add(parentModule);
	        }
	    }

	    return result;
	}

}
