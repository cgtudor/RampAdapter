/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rampadapter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author v8002382
 */
public class AirportRampAdapter implements Ramp{

    AirportRamp originalRamp;

    public AirportRampAdapter(AirportRamp originalRamp) {
        this.originalRamp = originalRamp;
    }
        
    @Override
    public int getId() {
        if(originalRamp.getSerialNumber() == null)
            return -1;
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(originalRamp.getSerialNumber()); 
        if(m.find()) 
        {
            return Integer.parseInt(m.group());
        }
        else
        {
            return -1;
        }
    }

    @Override
    public String dispatch() {
        return originalRamp.deploy();
    }

    @Override
    public boolean isDispatched() {
        return !originalRamp.isAvailable();
    }

    @Override
    public int getParkingBayNumber() {
        if(originalRamp.getParkingBay() == null)
            return -1;
        String parkingBay = originalRamp.getParkingBay();
        try
        {
            int pbNumber = Integer.parseInt(String.valueOf(parkingBay.substring(parkingBay.length()-2)));
            return pbNumber;
        }
        catch(NumberFormatException e)
        {
            return -1;
        }
    }

    @Override
    public boolean withdraw() {
        return originalRamp.detach() != null;      
    }
    
}
