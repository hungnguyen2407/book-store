package vn.edu.hcmuaf.bookstore.test;

import org.junit.Test;
import vn.edu.hcmuaf.bookstore.services.Ultilities;

public class UltilitiesTest {

    @Test
    public void encryptText() {
        System.out.println(Ultilities.encryptText("123456"));
    }
}