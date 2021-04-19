package com.ijmeet.utility;

import java.io.IOException;

public class GeneralUtil {
	
	/***
	 * @author Abhijit Paithane
	 * @param serviceName  service to kill in windows
	 */

	public static void killProcess(String serviceName) {

		try {
			Runtime.getRuntime().exec("taskkill /IM " + serviceName);
			System.out.println(serviceName+" killed successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
