package com.gemma.utils;


import org.apache.log4j.Level;

import java.io.*;


import java.util.Properties;

public class PropertyFileReader  {
     //static Properties props = new Properties();



    public PropertyFileReader() throws Exception {
    }


    public static Properties getPropertyFile(String fileName) throws Exception {

        File file = new File(System.getProperty("user.dir") + "/src/main/resources/configs/" + fileName);
        FileInputStream fileInputObj = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fileInputObj);
        return prop;
    }

    static Properties propertyReader;

    static {
        try {
            propertyReader = getPropertyFile("config.properties");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Properties getPropertyLocatorsFile(String fileName) throws Exception {

        File file = new File(System.getProperty("user.dir") + "/src/main/resources/configs/" + fileName);
        FileInputStream fileInputObj = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fileInputObj);
        return prop;
    }


    public static String getUsername() {
        return propertyReader.getProperty("username");
    }

    public static String getPassword() {
        return propertyReader.getProperty("password");
    }

    public static String getOracleUsername() {
        return propertyReader.getProperty("oracleUsername");
    }

    public static String getOraclePassword() {
        return propertyReader.getProperty("oraclePassword");
    }

    public static String getWebsite() {
        return propertyReader.getProperty("gemmaURL");
    }

    public int getPageLoadTimeOut() {
        return Integer.parseInt(propertyReader.getProperty("PageLoadTimeOut"));
    }

    public static int getImplicitWait() {
        return Integer.parseInt(propertyReader.getProperty("ImplicitWait"));
    }

    public int getExplicitWait() {
        return Integer.parseInt(propertyReader.getProperty("ExplicitWait"));
    }

    public static Level getLoggerLevel() {

        switch (propertyReader.getProperty("Logger.Level")) {

            case "DEBUG":
                return Level.DEBUG;
            case "INFO":
                return Level.INFO;
            case "WARN":
                return Level.WARN;
            case "ERROR":
                return Level.ERROR;
            case "FATAL":
                return Level.FATAL;
        }
        return Level.ALL;
    }
    }


