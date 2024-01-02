package org.example.writer.json;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.writer.IFileWriter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonWriter implements IFileWriter {

    private ObjectMapper objectMapper =new ObjectMapper();

    @Override
    public void write(List data, String outputPath) {
        try{
            objectMapper.writeValue(new File(outputPath),data);
        } catch (StreamWriteException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
