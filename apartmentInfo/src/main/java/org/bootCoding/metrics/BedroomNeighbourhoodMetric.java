package org.bootCoding.metrics;

import org.bootCoding.entities.House;
import org.bootCoding.metrics.collector.MetricCollector;
import org.bootCoding.metrics.counter.BedroomCounter;
import org.bootCoding.metrics.counter.NeighbouthoodCount;
import org.bootCoding.writer.json.JsonWriter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BedroomNeighbourhoodMetric implements MetricCollector {
    @Override
    public void collect(List<House> data) {
        Map<Integer,List<House>> bedroom = data.stream().collect(Collectors.groupingBy(House::getBedrooms));
        bedroom.forEach((bhk,record)->{
            Map<String,List<House>> bhkNeighbours = record.stream().collect(Collectors.groupingBy(House::getNeighbourhood));
            System.out.print(bhk+"BHK:"+record.size());
            bhkNeighbours.forEach((k,v)-> System.out.print("["+k+":"+v.size()+"]"));
            System.out.println();
        });

        Map<Integer, NeighbouthoodCount> countData = new HashMap<>();
        bedroom.forEach((bhk,record)->{
            Map<String,List<House>> bhkNeighbours = record.stream().collect(Collectors.groupingBy(House::getNeighbourhood));
//            System.out.println(bhk+"BHK:"+record.size());
            final NeighbouthoodCount neighbouthoodCount = NeighbouthoodCount.builder().total(record.size()).build();
            bhkNeighbours.entrySet().forEach((entry)->{
                setValues(entry,neighbouthoodCount);
            });
            countData.put(bhk,neighbouthoodCount);
        });
        BedroomCounter bedroomCounter = BedroomCounter.builder().bedroomCount(countData).build();
        JsonWriter.write(bedroomCounter);
    }
    private  void setValues(Map.Entry<String,List<House>> entry,NeighbouthoodCount neighbouthoodCount){
        if ("Rural".equals(entry.getKey())){
            neighbouthoodCount.setRural(entry.getValue().size());
        }else if ("Suburb".equals(entry.getKey())){
            neighbouthoodCount.setSuburb(entry.getValue().size());
        }else if ("Urban".equals(entry.getKey())){
            neighbouthoodCount.setUrban(entry.getValue().size());
        }
    }

}
