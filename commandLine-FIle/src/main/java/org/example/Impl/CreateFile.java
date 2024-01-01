package org.example.Impl;

import org.example.Command.Command;
import org.example.model.Result;
import org.example.validator.OptionValidator;

import java.io.File;

public class CreateFile implements Command, OptionValidator {
    @Override
    public Result execute(String[] attribute) throws Exception {

        String fileName = attribute[2];

        if (validate(attribute)){
            File file = new File(fileName);
            file.createNewFile();
            return Result.builder().message("File is created Successfully....").build();
        }
        return Result.builder().message("Invalid Create command arguments").build();
    }

    @Override
    public boolean validate(String[] attribute) throws Exception {
        if (attribute.length != 3){
            throw new Exception("Please Provide all inputs" + "create" +"-c" + "filename.txt");
        }

        if (!attribute[0].equals("create")){
            throw new Exception("Option is not create.");
        }else if (!attribute[1].equals("-c")){
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
        if (attName.equals("-c")) {
            return true;
        }
        return false;
    }
}
