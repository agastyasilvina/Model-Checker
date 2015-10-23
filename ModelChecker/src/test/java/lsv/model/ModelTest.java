package lsv.model;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import lsv.utils.ModelGenerator;


public class ModelTest {

    private ModelGenerator model;
    
        @Before
        public void before() throws Throwable {
           
        };

    @Test 
    public void test() {
        String modelFilePath = "C\:\Users\IBM_ADMIN\Documents\TASK\temporary\temporary\playground\ModelChecker\src\test\resources\model.json";
        try {
            model = new ModelGenerator(modelFilePath);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  
        assertTrue(true);
    }

}
