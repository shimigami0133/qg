package com.seimens.qualitygate.service.demo.entity;

import java.util.List;

public class JunitGateResult {
    private List<String> listOfTests;


    public List<String> getListOfTests() {
        return listOfTests;
    }

    public void setListOfTests(List<String> listOfTests) {
        this.listOfTests = listOfTests;
    }
}
