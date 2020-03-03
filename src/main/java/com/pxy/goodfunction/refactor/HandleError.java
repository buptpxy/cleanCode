package com.pxy.goodfunction.refactor;

import org.slf4j.Logger;

public class HandleError {
    enum Error {
        OK,
        FAILED,
        NO_SUCH,
        LOCKED,
        OUT_OF_RESOURCES,
        WAITING_FOR_EVENT;
    }
    class Name {
        String makeKey(){
            return "";
        }
    }
    class Page {
        Name name;
    }
    class Registry {
        Error deleteReference(Name name) {
            return Error.OK;
        }
        void deleteReference1(Name name) throws Exception {
            try {

            }catch (Exception e) {
                logger.error("deleteReference from registry failed");
                throw e;
            }
        };
    }
    class ConfigKeys {
        Error deleteKey(String str) {
            return Error.OK;
        };

        void deleteKey1(String makeKey) throws Exception {
            try {

            }catch (Exception e) {
                logger.error("configKey not deleted");
                throw e;
            }
        };
    }
    Page page = new Page();
    Registry registry = new Registry();
    Logger logger;
    ConfigKeys configKeys = new ConfigKeys();
    private Error deletePage(Page page) {
        return Error.OK;
    }
    private void deletePage1(Page page) throws Exception {
        try {
            logger.error("page deleted");
        }catch (Exception e) {
            logger.error("delete failed");
            throw e;
        }
    };
    /**
     * 原函数，使用错误码的方式来判断错误，使得错误判断代码与错误处理代码耦合
     * @return
     */
    public Error deepDelete() {
        if (deletePage(page) == Error.OK) {
            if (registry.deleteReference(page.name) == Error.OK) {
                if (configKeys.deleteKey(page.name.makeKey()) == Error.OK){
                    logger.error("page deleted");
                } else {
                    logger.error("configKey not deleted");
                }
            } else {
                logger.error("deleteReference from registry failed");
            }
        } else {
            logger.error("delete failed");
            return Error.FAILED;
        }
        return Error.OK;
    }

    /**
     * 使用try-catch方式后，对错误代码的处理就从主逻辑中解耦出来了，但把错误处理和正确流程混在一起，
     * 因此还需将try和catch中的代码处理抽象出来
     */
    public void deepDelete1() {
        try {
            deletePage1(page);
            registry.deleteReference1(page.name);
            configKeys.deleteKey1(page.name.makeKey());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * 继续改进后的代码，将正确流程、错误处理完全区分开
     */
    public void deepDelete2() {
        try {
            deletePageAndAllReference();
        } catch (Exception e) {
            logError(e);
        }
    }

    private void deletePageAndAllReference() throws Exception{
        deletePage1(page);
        registry.deleteReference1(page.name);
        configKeys.deleteKey1(page.name.makeKey());
    }

    private void logError(Exception e) {
        logger.error(e.getMessage());
    }


}
