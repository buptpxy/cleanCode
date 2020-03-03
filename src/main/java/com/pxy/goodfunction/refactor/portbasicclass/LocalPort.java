package com.pxy.goodfunction.refactor.portbasicclass;

import com.pxy.goodfunction.refactor.Port;
import com.pxy.goodfunction.refactor.portbasicclass.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalPort {
    private static final Logger logger = LoggerFactory.getLogger(Port.class);
    private ACMEPort port;
    public LocalPort(int portNum) {
        this.port = new ACMEPort(portNum);
    }
    public void open() throws PortDeviceFailure {
        try {
            port.open();
        } catch (DeviceResponseException e) {
            throw new PortDeviceFailure(e);
        } catch (ATM1212UnlockedException e) {
            throw new PortDeviceFailure(e);
        } catch (GMXError e) {
            throw new PortDeviceFailure(e);
        } finally {
            //...
        }
    }
}
