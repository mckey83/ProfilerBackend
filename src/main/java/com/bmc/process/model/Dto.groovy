package com.bmc.process.model;

import groovy.transform.Canonical;
import groovy.transform.Immutable;

import java.util.ArrayList;
import java.util.List;

@Immutable
class Dto {
	List<MethodService> method;
	Description description;
}
