package main.java.Service;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;
import main.java.Model.Pharma;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class Service {
    public Service(){

    }

    public void SavePharma(Pharma pharma) throws IOException {
        Gson gson= new Gson();
        String s= gson.toJson(pharma);
        String filePath= "D:\\PharmaData\\"+pharma.getGroup()+"\\";
        try{
            new File(filePath).mkdir();
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Tên hoặc Nhóm phải không có kí tự đặc biệt");
        }
        String fileName=filePath+pharma.getName()+".json";
        FileWriter fw= new FileWriter(fileName);
        fw.append(s);
        fw.close();
        log.info("Save data successful");
    }

    public Pharma findPharma(String name,String group) throws IOException {
        String fileName= "D:\\PharmaData\\"+group+"\\"+name;
        try{
            String s= new String(Files.readAllBytes(Paths.get(fileName)));
            log.info(s);
            Gson gson=new Gson();
            Pharma pharma=gson.fromJson(s,Pharma.class);
            return pharma;
        }catch(Exception e){
            return null;
        }
    }

    public List<Pharma> findAllGroup(String group) throws FileNotFoundException {
        String groupName= "D:\\PharmaData\\"+group;
        List<Pharma> ret= new ArrayList<Pharma>();
        try{
            File groupFolder= new File(groupName);
            Gson gson=new Gson();

            for(File file:groupFolder.listFiles()){
                Scanner sc= new Scanner(file);
                String s= sc.nextLine();
                Pharma pharma=gson.fromJson(s,Pharma.class);
                System.out.println(pharma);
                ret.add(pharma);
            }
        }catch (Exception e){
//            JOptionPane.showMessageDialog(null,"Nhóm không tồn tại");
        }
        return ret;
    }
}
