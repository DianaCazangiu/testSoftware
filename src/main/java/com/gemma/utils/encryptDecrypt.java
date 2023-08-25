package com.gemma.utils;

import javax.crypto.Cipher;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Properties;
import javax.crypto.spec.SecretKeySpec;
import static com.gemma.utils.PropertyFileReader.*;

public class encryptDecrypt {

  private static byte[] key;
  public static String decryptedData1;
  public static String decryptedData2;

  public static String decryptedData3;
  public static String decryptedData4;

  static Properties propertyReader;
  private static SecretKeySpec secretKey;

  static {
    try {
      propertyReader = getPropertyFile("config.properties");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static void init(final String myKey) {
    MessageDigest sha = null;
    try {
      key = myKey.getBytes("UTF-8");
      sha = MessageDigest.getInstance("SHA-1");
      key = sha.digest(key);
      key = Arrays.copyOf(key, 16);
      secretKey = new SecretKeySpec(key, "AES");
    } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }


  public static String encrypt(final String strToEncrypt, final String secret) {
    try {
      init(secret);
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      cipher.init(Cipher.ENCRYPT_MODE, secretKey);
      return Base64.getEncoder()
          .encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
    } catch (Exception e) {
      System.out.println("Error while encrypting: " + e.toString());
    }
    return null;
  }

  public static String decrypt(final String strToDecrypt, final String secret) {
    try {
      init(secret);
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
      cipher.init(Cipher.DECRYPT_MODE, secretKey);
      return new String(cipher.doFinal(Base64.getDecoder()
          .decode(strToDecrypt)));
    } catch (Exception e) {
      System.out.println("Error while decrypting: " + e.toString());
    }
    return null;
  }

  public static void main(String args[]) {

    final String secretKey = "tTdC6675#";

    String originalString = "";
    String encryptedString = encryptDecrypt.encrypt(originalString, secretKey) ;
    String decryptedString = encryptDecrypt.decrypt(encryptedString, secretKey) ;

    System.out.println(originalString);
    System.out.println(encryptedString);
    System.out.println(decryptedString);
  }

  public static CharSequence getDecryptUsername(String decryptedData1) {

    final String secretKey = "tTdC6675#";

    decryptedData1 = encryptDecrypt.decrypt(getUsername(), secretKey) ;
    //System.out.println(decryptedData1);

    return decryptedData1;
  }

  public static CharSequence getDecryptPassword(String decryptedData2) {

    final String secretKey = "tTdC6675#";

    decryptedData2 = encryptDecrypt.decrypt(getPassword(), secretKey) ;
    //System.out.println(decryptedData2);


    return decryptedData2;
  }

  public static CharSequence getDecryptOracleUsername(String decryptedData3) {

    final String secretKey = "tTdC6675#";

    decryptedData3 = encryptDecrypt.decrypt(getOracleUsername(), secretKey) ;
    //System.out.println(decryptedData3);

    return decryptedData3;
  }

  public static CharSequence getDecryptOraclePassword(String decryptedData4) {

    final String secretKey = "tTdC6675#";

    decryptedData4 = encryptDecrypt.decrypt(getOraclePassword(), secretKey) ;
    //System.out.println(decryptedData4);


    return decryptedData4;
  }
}
