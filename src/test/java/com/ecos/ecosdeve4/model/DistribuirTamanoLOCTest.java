/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecos.ecosdeve4.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Dev
 */
public class DistribuirTamanoLOCTest extends TestCase {
    
    public DistribuirTamanoLOCTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

   /**
     * Test of testCalcularValoresDefecto method, of class CalcularSimpsonRule.
     */
    public void testCalcularValoresDefecto() throws Exception {
        List<BigDecimal> loc = new ArrayList<BigDecimal>();
        loc.add(new BigDecimal(4.39526912447868500777303779614157974720001220703125));
        loc.add(new BigDecimal(8.50813824938922635965354857034981250762939453125));
        loc.add(new BigDecimal(16.4696209539400655330609879456460475921630859375));
        loc.add(new BigDecimal(31.881053929269871360929755610413849353790283203125));
        loc.add(new BigDecimal(61.713721431934828842713613994419574737548828125));
        DistribuirTamanoLOC ejercicio = new DistribuirTamanoLOC();
        ejercicio.calcularTamanosLoc();
        
        assertEquals(loc, ejercicio.getLocXmetodos());
        loc.clear();
        loc.add(new BigDecimal(6.3375179612117289451589385862462222576141357421875));
        loc.add(new BigDecimal(8.439281112126057138311807648278772830963134765625));
        loc.add(new BigDecimal(11.238069244993528883469480206258594989776611328125));
        loc.add(new BigDecimal(14.9650424813794220568752280087210237979888916015625));
        loc.add(new BigDecimal(19.928022473189496821532884496264159679412841796875));
        
        assertEquals(loc, ejercicio.getPaginasXcapitulo());
    }
}
