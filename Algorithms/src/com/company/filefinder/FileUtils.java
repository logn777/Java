package com.company.filefinder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FileUtils {

    private static InputStreamReader in;
    private static BufferedReader reader;
    private static FileInputStream fis;
    private static FileOutputStream fos;

    public static void createNewFile(String filename, int size) throws IOException {
        fos = new FileOutputStream(filename);

        if (filename.isEmpty() || size <= 0)
            return;
        String s = "Новый файл";
        fos.write(s.getBytes());
        fos.flush();
        fos.close();
    }

    public static void concatFile(String src1, String src2, String newFile) throws IOException{
        fos = new FileOutputStream(newFile);
        fis = new FileInputStream(src1);
        int fd;

        while ((fd = fis.read()) != -1) fos.write(fd);
        fis.close();

        fis = new FileInputStream(src2);
        while ((fd = fis.read()) != -1) fos.write(fd);
        fis.close();

        fis = new FileInputStream(newFile);
        System.out.println("Total bites reads = " + fis.available());
        fos.flush();
        fos.close();
    }

    public static int getNumberLinesFromFile(File file) throws IOException {
        reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(file), StandardCharsets.UTF_8));
        String line;
        int len = 0;
        while ((line = reader.readLine()) != null) {
            len++;
        }
        reader.close();
        return len;
    }

    public static int getTotalBytesReadFromFile(File file) throws IOException {
        fis = new FileInputStream(file);
        int fd, totalBytes;

        while ((fd = fis.read()) != -1);

        totalBytes = fis.available();

        fis.close();

        return totalBytes;
    }

    public static int getCountCharsFromLines(File file) throws IOException {
        reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(file), StandardCharsets.UTF_8));
        String line;
        int totalChars = 1;

        while ((line = reader.readLine()) != null) {
            totalChars *= line.length();
        }
        reader.close();
        return totalChars;
    }

    /**
     *
     * @param f1
     * @param f2
     * @return true if f1 > f2, else return false
     * @throws IOException
     */
    public static boolean compareFilesByNumberLines(File f1, File f2) throws IOException {
        return getNumberLinesFromFile(f1) > getNumberLinesFromFile(f2);
    }

    /**
     *
     * @param f1
     * @param f2
     * @return true if f1 > f2, else return false
     * @throws IOException
     */
    public static boolean compareFilesByNumberBytes(File f1, File f2) throws IOException {
        return getTotalBytesReadFromFile(f1) > getTotalBytesReadFromFile(f2);
    }


    /**
     *
     * @param f1
     * @param f2
     * @return true if f1 > f2, else return false
     * @throws IOException
     */
    public static boolean compareFilesByNumberChars(File f1, File f2) throws IOException {
        return getCountCharsFromLines(f1) > getCountCharsFromLines(f2);
    }
}
