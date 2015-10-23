package lsv.model;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

import lsv.utils.ModelGenerator;


public class ModelTest {

    private ModelGenerator model;
    
    @Rule
    public ExternalResource externalResource = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            String modelFilePath = "model.json";
             model = new ModelGenerator(modelFilePath);  
        };

        @Override
        protected void after() {
          
        };
    };
    
    @Test 
    public void test() {
        assertTrue(true);
    }

}
