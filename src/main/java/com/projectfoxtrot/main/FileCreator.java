package com.projectfoxtrot.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.projectfoxtrot.utils.Utils;

public class FileCreator {
	private String home, file, path, extension;
	private String new_line;
	private Scanner scan = new Scanner(System.in);
	private Utils util = new Utils();
	
	public void newFile() throws IOException {
		System.out.println("NEW FILE");
		home = System.getenv("USERPROFILE");
		file = util.toScan(scan, "Name");
		extension = "." + util.toScan(scan, "Extension");
		path = home + "\\" + file + extension;
		System.out.println("Content:");
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
			do {
			    new_line = scan.nextLine();
			    if (new_line.equals("/")) break;
			    writer.write(new_line);
			    writer.newLine();
			} while (true);
		}
		System.out.println("Created: " + path);
	}
}
