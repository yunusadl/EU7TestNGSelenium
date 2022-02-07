package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReaderTwo {

    private static Properties properties; //declare a variable

    //static blocks, it initiates everytime I call class name.

    static{

        String path = "configurationTwo.properties";


        try {

            properties = new Properties();

            FileInputStream file = new FileInputStream(path); // throws java io exception, checked excepiton //opening file in java memory

            properties.load(file);

            file.close();


        } catch (IOException e) {
            e.printStackTrace();
        }






    }

    public static String get (String keyName){

        return properties.getProperty(keyName);


    }






}
