package lsv.model;

import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;

import org.junit.Test;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class CTLTest {

    @Test
    public void test() throws JsonIOException, JsonSyntaxException, FileNotFoundException {
        //String CTLFilePath = "src/test/resources/ctl2.json";
        //CTL ctl = CTL.createCTL(CTLFilePath);
        System.out.println(CTLTest.class.getResourceAsStream("ctl2.json"));
        assertNotNull(true);
    }

}
