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
public interface AirportRamp {
    public String getSerialNumber();
    public String deploy();
    public boolean isAvailable();
    public String getParkingBay();
    public String detach();
}
