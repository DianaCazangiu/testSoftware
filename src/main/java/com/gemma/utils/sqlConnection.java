package com.gemma.utils;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import static com.gemma.utils.PropertyFileReader.getPropertyFile;
import static com.gemma.utils.encryptDecrypt.*;


public class sqlConnection {
  public static LocalDateTime date = LocalDateTime.now();

  public static DateTimeFormatter currentDate = DateTimeFormatter.ofPattern("dd-MMM-yy");

  public static String formattedDate = date.format(currentDate).toUpperCase();

  public static int finalCount;
  public static String value;

  public static Connection con;

  static Properties propertyReader;

  static {
    try {
      propertyReader = getPropertyFile("config.properties");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }


  public static Connection connectToOracleDatabase() {
    String url
        = "jdbc:oracle:thin:@10.50.174.15:1521/gem2.citrix.local"; // table details
//    String username = "GEMMA_OWN"; // MySQL credentials
//    String password = "GEMMA_OWN2014";

    String username = (String) getDecryptOracleUsername(decryptedData3); // MySQL credentials
    String password = (String) getDecryptOraclePassword(decryptedData4);

    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
    try {
      con = DriverManager.getConnection(
          url, username, password);

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    System.out.println(
        "Connection Established successfully");

    return con;
  }


  public static String getValueFromQueryResultSet() {
    String query
        = "select * from GEMMA_PUBLIC.vw_wi_note where user_id = 8088 and DATE_CREATED like '%" + formattedDate + "%' and rownum = 1"; // query to be run
    ResultSet rs = null;
    try {
      Statement st = con.createStatement();
      rs = st.executeQuery(query);
      System.out.println(query);

      while(rs.next()) {
        value = (rs.getString("ID_WI"));
        System.out.println(value);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return value;

  }

  public static ResultSet runFinalQuery()  {
    // query to be run
    String query1
        = "select count(*) from GEMMA_PUBLIC.vw_wi_note where user_id = 8088 and DATE_CREATED like '%" + formattedDate + "%' and ID_WI = " + getValueFromQueryResultSet(); // query to be run
    ResultSet resultSet = null;
    try {
      Statement st = con.createStatement();
      resultSet = st.executeQuery(query1);
      System.out.println(query1);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return resultSet;
  }

  public static int getFinalCount()  {
    waitHelper.hardWait(5000);
    ResultSet resultSet = runFinalQuery();
    try {
      while(resultSet.next()){
        finalCount = (resultSet.getInt(1));
        System.out.println(finalCount);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return finalCount;
  }
}
