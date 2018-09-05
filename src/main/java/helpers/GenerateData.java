package helpers;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

/**
 * Created by Anna on 30/03/2018.
 */
public class GenerateData {

    public static String generateEmail(int length){
        String allowedChars = "abcdefghijklmnopqrstuvwxyz” + “1234567890";
        String email = "";
        String temp = RandomStringUtils.random(length,allowedChars);

        email = temp.substring(0, temp.length()-9) + "@gmail.com";

        return email;
    }

    public static String generateString (int length){
        return RandomStringUtils.randomAlphabetic(length) + "_AT";
    }

    public static int generateNumbers (int length){
        return Integer.parseInt(RandomStringUtils.randomNumeric(length));
    }

    public static String generateUrl(int length) {
        String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
                "1234567890" +   //numbers
                "_-.";   //special characters
        String url="";
        String temp=RandomStringUtils.random(length,allowedChars);
        url=temp.substring(0,3)+"."+temp.substring(4,temp.length()-4)+"."+temp.substring(temp.length()-3);
        return url;
    }


}
