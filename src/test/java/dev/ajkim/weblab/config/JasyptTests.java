package dev.ajkim.weblab.config;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class JasyptTests {

    @Autowired
    StringEncryptor se;

    String testString = "ThisIsATestPassword";

    @Test
    public void stringEncryptTest(){
        String encryptedString = se.encrypt(testString);
        System.out.println(encryptedString);

        String decryptedString = se.decrypt(encryptedString);

        Assertions.assertEquals(decryptedString, testString);
    }

    @Value("${jasypt.test.password}")
    String testPassword;

    @Test
    public void decryptPropertiesTest(){
        Assertions.assertEquals(testString, testPassword);
    }

}
