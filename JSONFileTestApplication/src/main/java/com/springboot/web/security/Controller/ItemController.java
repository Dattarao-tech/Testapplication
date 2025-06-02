package com.springboot.web.security.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.web.security.Entity.Item;
import com.springboot.web.security.ServiceImp.ItemServiceImpl;


@RestController
@RequestMapping("/api")
public class ItemController {
	
	@Autowired(required = true)
	private ItemServiceImpl itemServiceImpl;
	@PostMapping("/")
	public List<Item> getuquieparentitem(@RequestBody List<Item> menuItems){
		
		List<Item> findUniqueParentItems = itemServiceImpl.findUniqueParentItems(menuItems);
		for(Item ie :findUniqueParentItems) {
			System.out.println(ie);
		}
		return menuItems;		
	}
}