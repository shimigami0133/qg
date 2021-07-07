package com.seimens.qualitygate.service.demo.entity;

import java.util.List;

public class Branch {
    private List<String> class_name;
    private List<String> lines_covered;
    private List<String> lines_valid;
    private List<String> branches_covered;
    private List<String> branches_valid;
    private List<String> complexity;

    public List<String> getClass_name() {
        return class_name;
    }

    public void setClass_name(List<String> class_name) {
        this.class_name = class_name;
    }

    public List<String> getLines_covered() {
        return lines_covered;
    }

    public void setLines_covered(List<String> lines_covered) {
        this.lines_covered = lines_covered;
    }

    public List<String> getLines_valid() {
        return lines_valid;
    }

    public void setLines_valid(List<String> lines_valid) {
        this.lines_valid = lines_valid;
    }

    public List<String> getBranches_covered() {
        return branches_covered;
    }

    public void setBranches_covered(List<String> branches_covered) {
        this.branches_covered = branches_covered;
    }

    public List<String> getBranches_valid() {
        return branches_valid;
    }

    public void setBranches_valid(List<String> branches_valid) {
        this.branches_valid = branches_valid;
    }

    public List<String> getComplexity() {
        return complexity;
    }

    public void setComplexity(List<String> complexity) {
        this.complexity = complexity;
    }
}
