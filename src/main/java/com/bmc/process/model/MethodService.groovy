package com.bmc.process.model;

import groovy.transform.Canonical;
import groovy.transform.Immutable;


@Immutable
class MethodService {
    int id;
    String className;
    String methodName;
    long duration;
    long threadId;
    String threadName;
    String parentMethod;
    String[] stack;
    long startTime;
    String path;
    String color;
}
