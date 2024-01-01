package org.example.Impl;

import org.example.Command.Command;
import org.example.model.Result;
import org.example.validator.OptionValidator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WriteFile implements Command, OptionValidator {
    @Override
    public Result execute(String[] attribute) throws Exception {

        String path = attribute[2];
        String content = attribute[3];

        if (validate(attribute)){
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            bufferedWriter.write(content);
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        return Result.builder().message("File has been Written Successfully....").build();
    }

    @Override
    public boolean validate(String[] attribute) throws Exception {
        
        if (attribute.length != 3){
            throw new Exception("Please Provide all inputs:" + " write" + " -w" + " filename.txt" + " content to write.");
        }

        if (!attribute[0].equals("write")){
            throw new Exception("Option is not create.");
        }else if (!attribute[1].equals("-w")){
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
        if (attName.equals("-w")) {
            return true;
        }
        return false;
    }
}
