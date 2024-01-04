package org.bootCoding.writer.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bootCoding.metrics.counter.BedroomCounter;
import org.bootCoding.metrics.counter.NeighbouthoodCount;
import org.bootCoding.writer.IFileWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public class JsonWriter implements IFileWriter {

private ObjectMapper objectMapper = new ObjectMapper();

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

    public static void write(BedroomCounter result) {
        try{
            ObjectMapper objmapper = new ObjectMapper();
            String lines = objmapper.writeValueAsString(result);
            FileWriter fileWriter = new FileWriter(new File("src/main/resources/output/PdfData/BedroomNeighbourhoodMetric.json"));
            fileWriter.write(lines);
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
