package com.projectfoxtrot.utils;

import java.util.Scanner;

public class Utils {
	
	public String toScan(Scanner scan, String prompt) {
		System.out.print(prompt + ": ");
		return scan.nextLine();
	}
}
