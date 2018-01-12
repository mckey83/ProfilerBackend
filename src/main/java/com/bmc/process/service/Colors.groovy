package com.bmc.process.service

class MyColors {
    int index = 0;
    def colors = ["red", "forestgreen", "black", "orange", "blue",
                  "yellow" ,"cyan", "grey", "salmon", "maroon", "burlywood ",
                  "lime","aqua", "olive", "teel", "fuchsia",
                  "darkolivegreen", "darkcyan", "darkturquoise"
    ];

    Map<Integer, String> threadColors = new HashMap<>();

    String get(int threadId) {
        if(threadColors.containsKey(threadId)){
            return threadColors.get(threadId);
        }
        else {
            threadColors.put(threadId, nextColor());
            return threadColors.get(threadId)
        }
    }

    String nextColor() {
        index++;
        if (index < colors.size() -1) {
            index;
        } else{
            index = 0;
        }
        return colors[index];
    }
}
