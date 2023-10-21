package Util;

import java.util.Random;

public class TestUtil {
    public static String generateRandomEmail(){
        Random random = new Random();
        String email = "JohnDoe" + random.nextLong() + "@email.com" ;
        System.out.println("Used email is: " + email);
        return email;
    }
}
