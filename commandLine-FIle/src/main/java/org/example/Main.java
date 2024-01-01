package org.example;

import org.example.Command.Command;
import org.example.Impl.CreateFile;
import org.example.Impl.Exit;
import org.example.Impl.ReadFile;
import org.example.Impl.WriteFile;
import org.example.model.Result;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true){
            Scanner sc = new Scanner(System.in);

            System.out.println("------------Command Line File Utility-------------");
            System.out.println("Operations: create use -c");
            System.out.println("Operations: write use -w");
            System.out.println("Operations: read use -r");
            System.out.println("Operations: delete use-d");
            System.out.println("example:create -c filename.txt");
            System.out.println("Enter here:");

            String option = sc.nextLine();
            String[] commandArg = option.split(" ");

            Command command = findCommand(commandArg[0]);
            if (null == command || command instanceof Exit){
                break;
            }
            try {
                Result result = command.execute(commandArg);
                System.out.println(result);
            }catch (Exception ex){
                System.err.println(ex.getMessage());
            }
        }
    }

    private static Command findCommand(String s) {
        switch (s){
            case "create":
                return new CreateFile();
            case "read":
                return new ReadFile();
            case "write":
                return new WriteFile();
            default:
                return null;
        }
    }
}