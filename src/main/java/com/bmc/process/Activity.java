package com.bmc.process;
import org.apache.log4j.Logger;
interface Activity {

    void doSomething();

    default void log(long start, long finish, Logger logger, String proccessId) {
        logger.debug(String.format("\"proccessId\":\"%s\", \"methodName\":\"%s\", \"start\":\"%d\",  \"finish\":\"%d\", \"duration\":\"%d\"}",
                proccessId, Thread.currentThread().getStackTrace()[2].getMethodName(), start, finish, (finish - start)));
    }
}