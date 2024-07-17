package com.ninzahrm.crm.webdriverUtility;

import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(10000);
		return randomNumber;
	}
	}
