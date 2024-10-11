package com.demoshop.utils;

import com.github.javafaker.Faker;

public class BillingUtils {
	
	public static Faker faker = new Faker();
	
	
	
	public static String getNameCity() {
		return faker.address().cityName();
	}

	public static String getAddress() {
		return faker.address().fullAddress();
	}
	
	public static String getPostalcode() {
		return faker.address().zipCode();
	}
   public static String getPhoneNo() {
	   return faker.phoneNumber().phoneNumber();
   }


}
