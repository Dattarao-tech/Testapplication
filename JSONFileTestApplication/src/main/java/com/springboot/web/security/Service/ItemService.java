package com.springboot.web.security.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.springboot.web.security.Entity.Item;

@Service
public interface ItemService {
	
	 public static List<Item> findUniqueParentItems(List<Item> menuItems) {
		 Set<String> parentModules = new HashSet<>();
	     Set<String> childModules = new HashSet<>();
	     List<Item> result = new ArrayList<>();
	     
	        for (Item item : menuItems) {
	            String parentModule = item.getParentModule();
	            String childModule = item.getChildModule();

	            childModules.add(childModule);

	            if (childModules.contains(parentModule)) {
	                childModules.remove(parentModule);
	            } else {
	                result.add(new Item(parentModule, childModule));
	                parentModules.add(parentModule);
	            }
	        }

	        return result;
	    }
	 public static void main(String[] args) {
		
	        List<Item> menuItems = List.of(
	                new Item("Save As", "Ms Word"),
	                new Item("File", "Save As"),
	                new Item("File", "New file"),
	                new Item("Ms Word", "docx"),
	                new Item("Ms Word", "doc"),
	                new Item("Save As", "pdf"),
	                new Item("View", "Layout"),
	                new Item("Layout", "Single"),
	                new Item("Layout", "Column 2")
	        );

	        List<Item> outputResult = findUniqueParentItems(menuItems);

	        // Print the result
	        for (Item item : outputResult) {
	            System.out.println(item);
	        }
	    }	
}
