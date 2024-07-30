package com.student.testing.helper;

public class DataNotFoundException extends Exception{
	 public DataNotFoundException() {
	        super("Data not found.");
	    }

	    public DataNotFoundException(String message) {
	        super(message);
	    }

}
