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
public class AirportMobileRampTest {
    
    public AirportMobileRampTest() {
        
    }
    
    /**
     * Test of getSerialNumber method, of class AirportMobileRamp.
     */
    @Test
    public void testGetSerialNumber() {
        final AirportRamp ramp = new AirportMobileRamp("CRE23SCENT", "AIRCREST-12");
        assertEquals(ramp.getSerialNumber(), "CRE23SCENT");
        System.out.println("Serial Number Getter test OK");
    }

    @Test
    public void testGetNullSerialNumber() {
        final AirportRamp ramp = new AirportMobileRamp(null, "AIRCREST-12");
        assertNull(ramp.getSerialNumber());
        System.out.println("Null Serial Number Getter test OK");
    }
    
    /**
     * Test of deploy method, of class AirportMobileRamp.
     */
    @Test
    public void testDeploy()
    {
        final AirportRamp ramp = new AirportMobileRamp("CRESCENT", "AIRCREST-12");
        assertEquals(ramp.deploy(), "GPS Updated and driver notified...");
        System.out.println("Deploy test OK");
    }

    /**
     * Test of isAvailable method, of class AirportMobileRamp.
     */
    @Test
    public void testIsAvailableAtCreation() {
        final AirportRamp ramp = new AirportMobileRamp("CRESCENT", "AIRCREST-12");
        assertTrue(ramp.isAvailable());
        System.out.println("IsAvailableAtCreation test OK");
    }

    /**
     * Test of isAvailable method, of class AirportMobileRamp.
     */
    @Test
    public void testIsAvailableAfterDeployment() {
        final AirportRamp ramp = new AirportMobileRamp("CRESCENT", "AIRCREST-12");
        ramp.deploy();
        assertFalse(ramp.isAvailable());
        System.out.println("IsAvailableAfterDeployment test OK");
    }
    
    /**
     * Test of isAvailable method, of class AirportMobileRamp.
     */
    @Test
    public void testIsAvailableAfterDeploymentAndDetach() {
        final AirportRamp ramp = new AirportMobileRamp("CRESCENT", "AIRCREST-12");
        ramp.deploy();
        ramp.detach();
        assertTrue(ramp.isAvailable());
        System.out.println("IsAvailableAfterDeploymentAndDetach test OK");
    }
    
    /**
     * Test of getParkingBay method, of class AirportMobileRamp.
     */
    @Test
    public void testGetParkingBay() {
        final AirportRamp ramp = new AirportMobileRamp("CRE23SCENT", "AIRCREST-12");
        assertEquals(ramp.getParkingBay(), "AIRCREST-12");
        System.out.println("Parking Bay Getter test OK");
    }
    
    /**
     * Test of getParkingBay method, of class AirportMobileRamp.
     */
    @Test
    public void testGetNullParkingBay() {
        final AirportRamp ramp = new AirportMobileRamp("CRE23SCENT", null);
        assertNull(ramp.getParkingBay());
        System.out.println("Null Parking Bay Getter test OK");
    }

    /**
     * Test of detach method, of class AirportMobileRamp.
     */
    @Test
    public void testDetach() {
        final AirportRamp ramp = new AirportMobileRamp("CRESCENT", "AIRCREST-12");
        ramp.deploy();
        assertEquals(ramp.detach(), "Ramp detached and driver called back...");
        System.out.println("Detach test OK");
    }
    
    /**
     * Test of detach method, of class AirportMobileRamp.
     */
    @Test
    public void testAlreadyDetached() {
        final AirportRamp ramp = new AirportMobileRamp("CRESCENT", "AIRCREST-12");
        ramp.deploy();
        ramp.detach(); 
        assertNull(ramp.detach());
        System.out.println("Already Detached test OK");
    }
    
}
