package com.zcr.test;

public class TestInstance {

    private static volatile TestInstance instance;

    private TestInstance() {

    }

    public static TestInstance getInstance() {
        if (instance == null) {
            synchronized (TestInstance.class) {
                if (instance == null) {
                    instance = new TestInstance();
                }
            }
        }
        return instance;
    }
}
