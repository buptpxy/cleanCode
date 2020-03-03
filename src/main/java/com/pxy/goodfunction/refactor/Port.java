package com.pxy.goodfunction.refactor;

import com.pxy.goodfunction.refactor.portbasicclass.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Port {
    private static final Logger logger = LoggerFactory.getLogger(Port.class);

    //原代码，抛出异常种类多，且对每种异常的处理都一样，占主逻辑篇幅太大
    public void open() {
        ACMEPort port = new ACMEPort(12);
        try {
            port.open();
        } catch (DeviceResponseException e) {
            reportPortError(e);
            logger.error("Device response exception", e);
        } catch (ATM1212UnlockedException e) {
            reportPortError(e);
            logger.error("Unlock exception", e);
        } catch (GMXError e) {
            reportPortError(e);
            logger.error("Device response exception");
        } finally {
            //...
        }
    }
    private void reportPortError(Exception e) {
    }

    //改进后的代码，将ACMEPort封装成了一个LocalPort对象，将它的几种不同的异常封装成了一种异常
    public void openPort() {
        LocalPort port = new LocalPort(12);
        try {
            port.open();
        } catch (PortDeviceFailure e) {
            reportPortError(e);
            logger.error(e.getMessage(),e);
        } finally {
            //...
        }
    }

}
