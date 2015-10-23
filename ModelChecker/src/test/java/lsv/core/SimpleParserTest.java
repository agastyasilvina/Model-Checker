package lsv.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import lsv.grammar.Formula;

public class SimpleParserTest {

    @Test
    public void parseCTL() throws RecognitionException {
       Formula formula =  SimpleParser.parseCTL("A(a U AF(b))");
       assertNull(formula.getActions());
       assertEquals(formula.getAp()[0], "a");
       assertFalse(formula.getApNeg()[0]);
       assertNotNull(formula.getNestedCTL()[1]);
       assertEquals(formula.getOperator(), "U");
       assertEquals(formula.getNestedCTL()[1].getQuantifier(),"AF");
    }

}
