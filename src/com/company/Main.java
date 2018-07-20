package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main objektas = new Main();
        objektas.dirbk();
        objektas.rasykIFaila();
    }


    public void dirbk(){
        String fileName = "duomenys.txt";

        File file = new File(fileName);
        FileReader reader=null;
        Miestas[] miestai=null;
        try {
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(reader!= null){
            Scanner skaityvas = new Scanner(reader);


            int eilKiekis = 0;
            while(skaityvas.hasNextLine()){
                skaityvas.nextLine();
                eilKiekis++;
            }

            skaityvas.close();
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            reader=null;
            try {
                reader = new FileReader(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            if(reader!= null) {
                skaityvas = new Scanner(reader);
            }

            miestai= new Miestas[eilKiekis];

            for(int i =0;i<eilKiekis;i++){
                Miestas mst = new Miestas();
                mst.vardas = skaityvas.next();
                mst.kiekis = skaityvas.nextInt();
                miestai[i]= mst;

            }
            skaityvas.close();
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        for (int i = 0; i < miestai.length; i++) {
            System.out.println(miestai[i].vardas+ ":"+miestai[i].kiekis);
        }


    }


    public void rasykIFaila(){
        String failoVardas= "duomenys.txt";
        File file = new File(failoVardas);
        FileWriter writer=null;
        try {
            writer= new FileWriter(failoVardas,true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(writer!=null){
            try {
                writer.write("\nSiauliai 70000");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
