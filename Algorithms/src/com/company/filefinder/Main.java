package com.company.filefinder;

import java.io.File;

public class Main {
    private static final String FILE_TYPE = ".h";
    private static final String FOLDER_PATH = "C:\\Program Files (x86)\\Java";

    public static void main(String[] args) {
	// write your code here
        long start_time = System.nanoTime();

        File startDir = new File(FOLDER_PATH);
        FileFinder ff = new FileFinder();
        FileUtils fu = new FileUtils();


        System.out.println("Время выполнения = " + (System.nanoTime() - start_time) * 0.000001f);
    }
}
