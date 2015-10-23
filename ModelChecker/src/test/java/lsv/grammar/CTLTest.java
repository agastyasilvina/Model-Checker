package lsv.grammar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;

import org.junit.Test;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import lsv.grammar.CTL;

public class CTLTest {

    @Test
    public void test() throws JsonIOException, JsonSyntaxException, FileNotFoundException {
        String CTLFilePath = "src/test/resources/ctl.json";
        CTL ctl = CTL.createCTL(CTLFilePath);
        assertNotNull(ctl);
        assertEquals(ctl.getFormula(), "AzFb(g && AG( A ( True cUd EF ( p || q ) ) ))");
        assertNotNull(ctl.getActionMap().get('b')[1],"act2");
    }

}
