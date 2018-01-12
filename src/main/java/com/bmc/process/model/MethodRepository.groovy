package com.bmc.process.model;

import groovy.transform.Canonical;

@Canonical
class MethodRepository {
    String className;
    int processId;
    String methodName;
    long start;
    long finish;
    long duration;
    long threadId;
    String threadName;
    String parenMethod;
    String path;
    String[] stack;
}
