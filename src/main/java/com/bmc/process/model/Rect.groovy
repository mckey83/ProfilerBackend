package com.bmc.process.model

import groovy.transform.Canonical
import groovy.transform.Immutable;

@Immutable
class Rect {
	int x;
    int y;
	int width;
	int height;
    String color;
}
