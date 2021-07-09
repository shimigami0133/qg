package com.seimens.qualitygate.service.demo.entity;

import java.util.List;

public class Coverage {
    private List<String> className;
    private List<String> linesCovered;
    private List<String> linesValid;
    private List<String> branchesCovered;
    private List<String> branchesValid;
    private List<String> complexity;

    public List<String> getClassName() {
        return className;
    }

    public void setClassName(List<String> className) {
        this.className = className;
    }

    public List<String> getLinesCovered() {
        return linesCovered;
    }

    public void setLinesCovered(List<String> linesCovered) {
        this.linesCovered = linesCovered;
    }

    public List<String> getLinesValid() {
        return linesValid;
    }

    public void setLinesValid(List<String> linesValid) {
        this.linesValid = linesValid;
    }

    public List<String> getBranchesCovered() {
        return branchesCovered;
    }

    public void setBranchesCovered(List<String> branchesCovered) {
        this.branchesCovered = branchesCovered;
    }

    public List<String> getBranchesValid() {
        return branchesValid;
    }

    public void setBranchesValid(List<String> branchesValid) {
        this.branchesValid = branchesValid;
    }

    public List<String> getComplexity() {
        return complexity;
    }

    public void setComplexity(List<String> complexity) {
        this.complexity = complexity;
    }
}
