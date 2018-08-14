package com.ky.test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/*
 *作者：barret
 *日期：2018年2月5日
 *
*/

public class FileReadingTest {

	public static void main(String[] args) throws IOException {
		System.out.println(new String(Files.readAllBytes(Paths.get("D:\\test.txt"))));
		
		List<String> lines = Files.readAllLines(Paths.get("D:\\test.txt"),StandardCharsets.UTF_8);
		StringBuilder sb = new StringBuilder();
		for(String line : lines){
			sb.append(line);
		}
		String fromfile = sb.toString();
		System.out.println(fromfile);
	}
}
