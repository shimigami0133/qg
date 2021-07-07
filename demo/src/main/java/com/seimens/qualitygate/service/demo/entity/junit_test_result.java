package com.seimens.qualitygate.service.demo.entity;

import java.util.List;

public class junit_test_result {
    private List<String> Run;
    private List<String> Pass;
    private List<String> Intermittent;
    private List<String> Failed;
    private List<String> Errors;
    private List<String> Skipped;

    public List<String> getRun() {
        return Run;
    }

    public void setRun(List<String> run) {
        Run = run;
    }

    public List<String> getPass() {
        return Pass;
    }

    public void setPass(List<String> pass) {
        Pass = pass;
    }

    public List<String> getIntermittent() {
        return Intermittent;
    }

    public void setIntermittent(List<String> intermittent) {
        Intermittent = intermittent;
    }

    public List<String> getFailed() {
        return Failed;
    }

    public void setFailed(List<String> failed) {
        Failed = failed;
    }

    public List<String> getErrors() {
        return Errors;
    }

    public void setErrors(List<String> errors) {
        Errors = errors;
    }

    public List<String> getSkipped() {
        return Skipped;
    }

    public void setSkipped(List<String> skipped) {
        Skipped = skipped;
    }
}
