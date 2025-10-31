package com.projectfoxtrot.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import com.projectfoxtrot.utils.Utils;

public class FileCreator {
	private Terminal terminal;
	private LineReader reader;
	private String home, file, path, extension;
	private String new_line;
	private Utils util = new Utils();
	
	public FileCreator() {
		try {
			terminal = TerminalBuilder.builder().system(true).build();
			reader = LineReaderBuilder.builder()
		            .terminal(terminal)
		            .build();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void newFile() throws IOException {
		System.out.println("NEW FILE");
		home = System.getenv("USERPROFILE");
		file = util.toScan(reader, "Name");
		extension = "." + util.toScan(reader, "Extension");
		path = home + "\\" + file + extension;
		System.out.println("Content:");
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
			do {
			    new_line = reader.readLine();
			    if (new_line.equals("/")) break;
			    writer.write(new_line);
			    writer.newLine();
			} while (true);
		}
		System.out.println("Created: " + path);
	}

	public LineReader getReader() {
		return reader;
	}
}
