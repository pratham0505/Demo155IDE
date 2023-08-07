package com.cjc.main.Model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponce<P> {
	
	private int ResponceStatus;
	private String responceMsg;
	private Date responceDate;
	private P responceData;

}
