package com.bmc.process.service


import com.bmc.process.model.*
import com.bmc.process.repository.FileRepository
import com.bmc.process.repository.Repository
import groovy.transform.Canonical

import java.util.stream.Collectors

@Canonical
class ServiceSimple {
    int VIEW_TYPE = 0
    int Y_HEIGHT = 10
    int id = 1

    String PATH_TO_JSON_FILE = "D:\\workspace\\ProfilerUI\\src\\assets\\file.json"
    String PATH_TO_LOG = "D:\\workspace\\tomcat\\logs\\ux-mta.log"
    def trash = ["hashCode","equals", "compare", "lambda\$", "Convert", "getLogMessage", "logMethod", "shouldLog", "toString", "writeToLog", "aroundWriteTo", "log"]

    Repository repository = new FileRepository()
    MyColors colors = new MyColors()

    public void proceed() {
        try {
            List<MethodRepository> methodsByStartTime = read().toSorted{a -> a.start}

            long startTime = methodsByStartTime[0].start

            ArrayList<MethodService> methodsResult = methodsByStartTime.stream()
                    .filter { method -> !isContain(method) }
                    .filter { method -> method.duration > 100000000 }
                    .map { method ->
                        new MethodService(
                            id++,
                            getClassName(method),
                            method.methodName,
                            method.duration,
                            method.threadId,
                            method.threadName,
                            method.parenMethod,
                            method.stack,
                            method.start - startTime,
                            method.path,
                            getColor((int) method.threadId)
                        )
                       }
                    .collect(Collectors.toList())

            methodsResult.stream().forEach{res -> println(res.startTime+" "+res.methodName)}
            println(methodsResult.size())

            def dto = new Dto(
                    methodsResult,
                    new Description(new Rect(0, 0, 0, 0,"forestgreen")))
            write(dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    List<MethodRepository> read() throws IOException {
        return repository.read(PATH_TO_LOG);
    }

    void write(Dto dto) throws IOException {
        repository.write(dto, PATH_TO_JSON_FILE);
    }

    private String getClassName(MethodRepository method) {
        def className = method.className
        if(className.equals('0'))
            return ''
        className = className.replace('com.bmc.bsm.myit', '')
    }

    boolean isContain(MethodRepository method) {
        for (String current : trash) {
            if (method.methodName.contains(current)) return  true
        }
        false
    }

    String getColor(int threadId){
        return colors.get(threadId)
    }
}
