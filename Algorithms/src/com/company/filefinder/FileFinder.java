package com.company.filefinder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class FileFinder {

    private final ArrayList<File> listFiles = new ArrayList<>();

    public ArrayList<File> getListFiles() {
        return listFiles;
    }

    public int getListFilesSize() {
        return listFiles.size();
    }

    public void addToList(File file) {
        if (!file.isDirectory())
            listFiles.add(file);
    }

    public void addToList(File[] files) {
        for (File entry : files)
            addToList(entry);
    }

    private void searchFilesFromFolder(File root)
    {
        File[] folderEntries = root.listFiles();

        assert folderEntries != null;

        addToList(folderEntries);

        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                searchFilesFromFolder(entry);
            }
        }
    }

    ArrayList<File> getFoundFiles(File root){
        searchFilesFromFolder(root);

        return listFiles;
    }

    public void printAllFiles() {
        for (File entry : listFiles)
            System.out.println(entry.getAbsolutePath() + " -> " + entry.getName());
    }

    public void ClearListFiles() { listFiles.clear(); }


    public boolean checkFileName(String file, String name) {
        return file.equals(name);
    }

    public Optional<String> getExtensionByStringHandling(String filename) {
        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }

    public boolean checkFileType(File filename, String type) {
        char[] buf = filename.getName().toCharArray();
        char[] typeBuf = new char[type.length()];

        Optional<String> s = getExtensionByStringHandling(filename.getName());

        if (s.isPresent())
            typeBuf = s.get().toCharArray();

        return Arrays.equals(type.toCharArray(), typeBuf);
    }

    public void printFilesByType(String type) {
        for (File entry : listFiles)
            if (checkFileType(entry, type))
                System.out.println(entry.getAbsolutePath() + " -> " + entry.getName());
    }

    public void printFilesByName(String name) {
        for (File entry : listFiles)
            if (checkFileName(entry.getName(), name))
                System.out.println(entry.getAbsolutePath() + " -> " + entry.getName());
    }

    public File getByType(File file, String type){
        for (File entry : listFiles)
            if (checkFileType(entry, type))
                return entry;
        return null;
    }

    public File getByName(File file, String name){
        for (File entry : listFiles)
            if (checkFileName(entry.getName(), name))
                return entry;
        return null;
    }
}
