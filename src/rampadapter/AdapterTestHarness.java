/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rampadapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author v8002382
 */
public class AdapterTestHarness {
    public static void main(String[] args) throws InterruptedException
    {
        List<Ramp> ramps = new ArrayList<>();
        Random r = new Random();
        for(int i = 0; i < 100; i ++)
        {
            AirportRamp aFixedRamp = new AirportFixedRamp(getRandomSerialNumber(15), getRandomParkingBay(10));
            AirportRamp aMobileRamp = new AirportMobileRamp(getRandomSerialNumber(15), getRandomParkingBay(10));
            Ramp fixedRamp = new FixedRamp(Math.abs(r.nextInt() % 100), Math.abs(r.nextInt() % 100));
            Ramp mobileRamp = new MobileRamp(Math.abs(r.nextInt() % 100), Math.abs(r.nextInt() % 100));
            AirportRampAdapter fixedAdaptedRamp = new AirportRampAdapter(aFixedRamp);
            AirportRampAdapter mobileAdaptedRamp = new AirportRampAdapter(aMobileRamp);
            ramps.add(fixedRamp);
            ramps.add(mobileRamp);
            ramps.add(fixedAdaptedRamp);
            ramps.add(mobileAdaptedRamp);
        }
        Thread.sleep(5000);
        dispatchRamp(ramps, 50);
        Thread.sleep(5000);
        for(Ramp ramp : ramps)
        {
            System.out.println(ramp.getClass());
            System.out.println(ramp.getId());
        }
    }
    
    static boolean dispatchRamp(List<Ramp> ramps, int pbNumber)
    {
        for(Ramp ramp : ramps)
        {
            if(ramp.getParkingBayNumber() == pbNumber)
            {
                System.out.println(ramp.dispatch());
                return true;
            }
        }
        return false;
    }
    
    static String getRandomParkingBay(int n) 
    { 
  
        // lower limit for Letters 
        int lowerLimit = 65; 
  
        // lower limit for Letters 
        int upperLimit = 90; 
  
        Random random = new Random(); 
  
        // Create a StringBuffer to store the result 
        StringBuffer r = new StringBuffer(n); 
  
        for (int i = 0; i < n; i++) { 
  
            if(i >= n - 2)
            {
                r.append(String.valueOf(Math.abs(random.nextInt() % 10)));
                continue;
            }
            int nextRandomChar = lowerLimit 
                                 + (int)(random.nextFloat() 
                                         * (upperLimit - lowerLimit + 1)); 
  
            // append a character at the end of bs 
            r.append((char)nextRandomChar); 
        } 
  
        // return the resultant string 
        return r.toString(); 
    } 
    static String getRandomSerialNumber(int n) 
    { 
  
        // lower limit for Letters 
        int lowerLimit = 65; 
  
        // lower limit for Letters 
        int upperLimit = 90; 
  
        Random random = new Random(); 
  
        // Create a StringBuffer to store the result 
        StringBuffer r = new StringBuffer(n); 
  
        for (int i = 0; i < n; i++) { 
  
            if(i >= n/2 && i <= n/2 + 1)
            {
                r.append(String.valueOf(Math.abs(random.nextInt() % 10)));
                continue;
            }
            int nextRandomChar = lowerLimit 
                                 + (int)(random.nextFloat() 
                                         * (upperLimit - lowerLimit + 1)); 
  
            // append a character at the end of bs 
            r.append((char)nextRandomChar); 
        } 
  
        // return the resultant string 
        return r.toString(); 
    } 
}
