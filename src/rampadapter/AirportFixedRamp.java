/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rampadapter;

/**
 *
 * @author v8002382
 */
public class AirportFixedRamp implements AirportRamp{

    private String serialNumber;
    private String parkingBay;
    private boolean isAvailable;

    public AirportFixedRamp(String serialNumber, String parkingBay) {
        this.serialNumber = serialNumber;
        this.parkingBay = parkingBay;
        isAvailable = true;
    }
    
    @Override
    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public String deploy() {
        isAvailable = false;
        return "Ramp deploying timer (5 seconds) started...";
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String getParkingBay() {
        return parkingBay;
    }

    @Override
    public String detach() {
        if(isAvailable == true)
            return null;
        isAvailable = true;
        return "Ramp detached...";
    }
    
}
