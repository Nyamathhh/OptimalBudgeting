/**
 * 
 */
package com.optily.OptimalBudgeting.model;

import java.io.Serializable;

/**
 * @author shaik
 *
 */
public class Request<T> implements Serializable {
//	private static final long serialVersionUID  =

	private HeaderModel header;
	
	private T payLoad;

	public HeaderModel getHeader() {
		return header;
	}

	public void setHeader(HeaderModel header) {
		this.header = header;
	}

	public T getPayLoad() {
		return payLoad;
	}

	public void setPayLoad(T payLoad) {
		this.payLoad = payLoad;
	}
	
	
}
