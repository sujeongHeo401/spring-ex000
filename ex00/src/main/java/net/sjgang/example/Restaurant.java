package net.sjgang.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.ToString;

@Component
@ToString
public class Restaurant {
	
	@Autowired
	private Chef chef;
	

}
