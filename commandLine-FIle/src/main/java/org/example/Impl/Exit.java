package org.example.Impl;

import org.example.Command.Command;
import org.example.model.Result;

public class Exit implements Command {
    @Override
    public Result execute(String[] attribute) throws Exception {
        return null;
    }
}
