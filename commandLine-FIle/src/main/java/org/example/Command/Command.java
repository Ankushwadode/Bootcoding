package org.example.Command;

import org.example.model.Result;

public interface Command {

    public Result execute(String[] attribute) throws Exception;
}
