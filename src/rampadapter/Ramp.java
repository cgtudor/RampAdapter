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
public interface Ramp {
    public int getId();
    public String dispatch();
    public boolean isDispatched();
    public int getParkingBayNumber();
    public boolean withdraw();
}
