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
public class FixedRamp implements Ramp{

    private int id;
    private int parkingBayNumber;
    private boolean isDispatched;

    public FixedRamp(int id, int parkingBayNumber) {
        this.id = id;
        this.parkingBayNumber = parkingBayNumber;
        isDispatched = false;
    }
    
    @Override
    public int getId() {
        return id;
    }

    @Override
    public String dispatch() {
        isDispatched = true;
        return "Ramp safety security module released. Commencing dispatch.";
    }

    @Override
    public boolean isDispatched() {
        return isDispatched;
    }

    @Override
    public int getParkingBayNumber() {
        return parkingBayNumber;
    }

    @Override
    public boolean withdraw() 
    {
        if(!isDispatched)
            return false;
        isDispatched = false;
        return true;
    }
    
}
