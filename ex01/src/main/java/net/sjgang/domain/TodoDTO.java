package net.sjgang.domain;

import java.util.Date;

import lombok.Data;

@Data
public class TodoDTO {
	
	private String title;
	private Date dueDate;

}
