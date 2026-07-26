package com.sts.topic;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SingleService {
	
	public List<StockSingle>  getSingle(){
		return List.of(new StockSingle("irfc", "insider buy", "promotoe incresded stack"),
				new StockSingle("Bel", "divided Alert ", "final divide declere"),
				new StockSingle("nhpc", "Breakout", "Technical breakout above resitance"));
	}
}
