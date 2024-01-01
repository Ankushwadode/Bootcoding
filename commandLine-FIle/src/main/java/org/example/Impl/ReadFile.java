package org.example.Impl;

import org.example.Command.Command;
import org.example.model.Result;
import org.example.validator.OptionValidator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFile implements Command, OptionValidator {

    @Override
    public Result execute(String[] attribute) throws Exception {

        String path = attribute[2];
        File file = new File(path);

        if (validate(attribute)){
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }
        return Result.builder().message("File Read complete Successfully....").build();
    }

    @Override
    public boolean validate(String[] attribute) throws Exception {
        if (attribute.length != 3){
            throw new Exception("Please Provide all inputs:" + " read" +" -r" + " filename.txt");
        }

        //validate command format
        if (!attribute[0].equals("read")){
            throw new Exception("Option is not create.");
        }else if (!attribute[1].equals("-r")){
            throw new Exception("Invalid command read.");
        } else if (!attribute[2].endsWith(".txt")) {
            throw new Exception("can only create .txt files");
        }

        boolean isValid = true;
        int i = 1;

        while (isValid && i< attribute.length){
            String attName = attribute[i];
            isValid =validAttribute(attName);
            i += 2;
        }
        return isValid;
    }

    private boolean validAttribute(String attName){
        if (attName.equals("-r")) {
            return true;
        }
        return false;
    }
}
