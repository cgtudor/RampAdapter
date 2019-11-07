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
public class MobileRamp implements Ramp{

    private int id;
    private int parkingBayNumber;
    private boolean isDispatched;

    public MobileRamp(int id, int parkingBayNumber) {
        this.id = id;
        this.parkingBayNumber = parkingBayNumber;
        isDispatched = false;
    }
    
    @Override
    public int getId() {
        return Math.abs(id);
    }

    @Override
    public String dispatch() {
        if(isDispatched)
            return null;
        isDispatched = true;
        return "Ramp driver notified of destination. Commencing transport.";
    }

    @Override
    public boolean isDispatched() {
        return isDispatched;
    }

    @Override
    public int getParkingBayNumber() {
        return Math.abs(parkingBayNumber);
    }

    @Override
    public boolean withdraw() {
        if(!isDispatched)
            return false;
        isDispatched = false;
        return true;
    }
    
}
