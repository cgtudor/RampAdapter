/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rampadapter;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author v8002382
 */
public class RampAdapterTest {
    
    public RampAdapterTest() {
    }

    //The Id is the first number found inside the serial number.
    @Test
    public void testGetId()
    {
        final AirportRamp ramp = new AirportMobileRamp("CRE23SCENT", "AIRCREST-12");
        final Ramp adapted = new AirportRampAdapter(ramp);
        assertEquals(adapted.getId(), 23);
        System.out.println("Id test OK");
    }
    
    //There can be multiple numbers in a serial number, but only the first one found sould be considered the Id.
    @Test
    public void testMultipleNumbersGetId()
    {
        final AirportRamp ramp = new AirportMobileRamp("CRE23SCE43NT", "AIRCREST-12");
        final Ramp adapted = new AirportRampAdapter(ramp);
        assertEquals(adapted.getId(), 23);
        System.out.println("Id test OK");
    }
    
    //No number inside the serial number;
    @Test
    public void testInvalidGetId()
    {
        final AirportRamp ramp = new AirportMobileRamp("CRESCENT", "AIRCREST-12");
        final Ramp adapted = new AirportRampAdapter(ramp);
        assertEquals(adapted.getId(), -1);
        System.out.println("InvalidId test OK");
    }
    
    @Test
    public void testNullGetId()
    {
        final AirportRamp ramp = new AirportMobileRamp(null, "AIRCREST-12");
        final Ramp adapted = new AirportRampAdapter(ramp);
        assertEquals(adapted.getId(), -1);
        System.out.println("InvalidId test OK");
    }
    
    @Test
    public void testGetParkingBayNumber()
    {
        final AirportRamp ramp = new AirportMobileRamp("23CRESCENT", "AIRCREST-12");
        final Ramp adapted = new AirportRampAdapter(ramp);
        assertEquals(adapted.getParkingBayNumber(), 12);
        System.out.println("ParkingBayNumber test OK");
    }
    
    @Test
    public void testInvalidGetParkingBayNumber()
    {
        final AirportRamp ramp = new AirportMobileRamp("23CRESCENT", "AIRCREST-A2");
        final Ramp adapted = new AirportRampAdapter(ramp);
        assertEquals(adapted.getParkingBayNumber(), -1);
        System.out.println("InvalidParkingBayNumber test OK");
    }
    
    @Test
    public void testNullGetParkingBayNumber()
    {
        final AirportRamp ramp = new AirportMobileRamp("23CRESCENT", null);
        final Ramp adapted = new AirportRampAdapter(ramp);
        assertEquals(adapted.getParkingBayNumber(), -1);
        System.out.println("InvalidParkingBayNumber test OK");
    }
    
    @Test
    public void testDispatch()
    {
        final AirportRamp ramp = new AirportMobileRamp("CRESCENT", "AIRCREST-12");
        final Ramp adapted = new AirportRampAdapter(ramp);
        assertEquals(adapted.dispatch(), "GPS Updated and driver notified...");
        System.out.println("Dispatch test OK");
    }
    
    @Test
    public void testIsDispatched()
    {
        final AirportRamp ramp = new AirportMobileRamp("23CRESCENT", "AIRCREST-12");
        final Ramp adapted = new AirportRampAdapter(ramp);
        adapted.dispatch();
        assertTrue(adapted.isDispatched());
        System.out.println("IsDispatched test OK");
    }
    
    @Test
    public void testWithdraw()
    {
        final AirportRamp ramp = new AirportMobileRamp("CRESCENT", "AIRCREST-12");
        final Ramp adapted = new AirportRampAdapter(ramp);
        adapted.dispatch();
        assertTrue(adapted.withdraw());
        System.out.println("Withdraw test OK");
    }
    
    @Test
    public void testInvalidWithdraw()
    {
        final AirportRamp ramp = new AirportMobileRamp("CRESCENT", "AIRCREST-12");
        final Ramp adapted = new AirportRampAdapter(ramp);
        assertFalse(adapted.withdraw());
        System.out.println("Withdraw test OK");
    }
    
    @Test
    public void testSideBySide()
    {
        final AirportRamp mobileRamp = new AirportMobileRamp("23CRESCENT", "AIRCREST-12");
        final Ramp fixedRamp = new FixedRamp(23,12);
        final Ramp adapted = new AirportRampAdapter(mobileRamp);
        fixedRamp.dispatch();
        adapted.dispatch();
        assertEquals(adapted.getParkingBayNumber(), fixedRamp.getParkingBayNumber());
        assertEquals(adapted.getId(), fixedRamp.getId());
        assertEquals(adapted.isDispatched(), fixedRamp.isDispatched());
        System.out.println("ParkingBayNumber test OK");
    }
    
}
