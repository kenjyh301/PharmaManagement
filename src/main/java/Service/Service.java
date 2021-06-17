package main.java.Service;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import main.java.Model.Pharma;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
public class Service {
    public Service(){

    }

    public void SavePharma(Pharma pharma) throws IOException {
        Gson gson= new Gson();
        String s= gson.toJson(pharma);
        String filePath= "D:\\PharmaData\\"+pharma.getGroup()+"\\";
        new File(filePath).mkdir();
        String fileName=filePath+pharma.getName()+".json";
        FileWriter fw= new FileWriter(fileName);
        fw.append(s);
        fw.close();
        log.info("Save data successful");
    }

    public Pharma findPharma(String name,String group) throws IOException {
        String fileName= "D:\\PharmaData\\"+group+"\\"+name;
        String s= new String(Files.readAllBytes(Paths.get(fileName)));
        log.info(s);
        Gson gson=new Gson();
        Pharma pharma=gson.fromJson(s,Pharma.class);
        return pharma;
    }
}
