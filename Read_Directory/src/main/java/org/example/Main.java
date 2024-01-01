package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting!!!");

        Scanner scanner = new Scanner(System.in);

        //get path from user to scan/read
        String path = null;

        System.out.println("Enter the path to Scan/Read files form: ");
        System.out.println("example - D:\\workspace\\BootCoding\\bootcoding-real-time-project-practice");
        System.out.print("Enter your file/folder path: ");

        path = scanner.nextLine();

        System.out.println("Provided path is: "+path);

        Directory_read read = new Directory_read();
        read.listAllFolder(path);
    }
}