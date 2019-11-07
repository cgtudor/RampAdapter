/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rampadapter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author v8002382
 */
public class FixedRampTest {
    
    public FixedRampTest() {
    }
    
    /**
     * Test of getId method, of class FixedRamp.
     */
    @Test
    public void testGetId() {
        Ramp ramp = new FixedRamp(23, 12);
        assertEquals(ramp.getId(), 23);
        System.out.println("Get ID test ok");
    }

    /**
     * Test of getId method, of class FixedRamp.
     */
    @Test
    public void testGetNegativeId() {
        Ramp ramp = new FixedRamp(-23, 12);
        assertEquals(ramp.getId(), 23);
        System.out.println("Get Negative ID test ok");
    }
    
    
    /**
     * Test of dispatch method, of class FixedRamp.
     */
    @Test
    public void testDispatch() {
        final Ramp ramp = new FixedRamp(23, 12);
        assertEquals(ramp.dispatch(), "Ramp safety security module released. Commencing dispatch.");
        System.out.println("Dispatch test OK");
    }

    /**
     * Test of dispatch method, of class FixedRamp.
     */
    @Test
    public void testDispatchAfterDispatch() {
        final Ramp ramp = new FixedRamp(23, 12);
        ramp.dispatch();
        assertNull(ramp.dispatch());
        System.out.println("Dispatch After Dispatch test OK");
    }

    
    /**
     * Test of isDispatched method, of class FixedRamp.
     */
    @Test
    public void testIsDispatchedAtCreation() {
        final Ramp ramp = new FixedRamp(23, 12);
        assertFalse(ramp.isDispatched());
        System.out.println("IsDispatchedAtCreation test OK");
    }
    
    /**
     * Test of isDispatched method, of class FixedRamp.
     */
    @Test
    public void testIsDispatchedAfterDeploy() {
        final Ramp ramp = new FixedRamp(23, 12);
        ramp.dispatch();
        assertTrue(ramp.isDispatched());
        System.out.println("IsDispatchedAfterDispatch test OK");
    }
    
     /**
     * Test of isDispatched method, of class FixedRamp.
     */
    @Test
    public void testIsDispatchedAfterDeployAndWithdraw() {
        final Ramp ramp = new FixedRamp(23, 12);
        ramp.dispatch();
        ramp.withdraw();
        assertFalse(ramp.isDispatched());
        System.out.println("IsDispatchedAfterDispatchAndWithdraw test OK");
    }

    /**
     * Test of getParkingBayNumber method, of class FixedRamp.
     */
    @Test
    public void testGetParkingBayNumber() {
        final Ramp ramp = new FixedRamp(23, 12);
        assertEquals(ramp.getParkingBayNumber(), 12);
        System.out.println("Parking Bay Number Getter test OK");
    }
    
    /**
     * Test of getParkingBayNumber method, of class FixedRamp.
     */
    @Test
    public void testGetNegativeParkingBayNumber() {
        final Ramp ramp = new FixedRamp(23, -12);
        assertEquals(ramp.getParkingBayNumber(), 12);
        System.out.println("Negative Parking Bay Number Getter test OK");
    }

    /**
     * Test of withdraw method, of class FixedRamp.
     */
    @Test
    public void testWithdraw() {
        final Ramp ramp = new FixedRamp(23, -12);
        ramp.dispatch();
        assertTrue(ramp.withdraw());
        System.out.println("Withdraw test OK");
    }
    
    /**
     * Test of withdraw method, of class FixedRamp.
     */
    @Test
    public void testWithdrawBeforeDispatch() {
        final Ramp ramp = new FixedRamp(23, -12);
        assertFalse(ramp.withdraw());
        System.out.println("Withdraw Before Dispatch test OK");
    }
    
    /**
     * Test of withdraw method, of class FixedRamp.
     */
    @Test
    public void testWithdrawAfterWithdraw() {
        final Ramp ramp = new FixedRamp(23, -12);
        ramp.dispatch();
        ramp.withdraw();
        assertFalse(ramp.withdraw());
        System.out.println("Withdraw after Withdraw test OK");
    }
    
}
