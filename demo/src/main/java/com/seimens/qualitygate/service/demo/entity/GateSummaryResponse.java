package com.seimens.qualitygate.service.demo.entity;
public class GateSummaryResponse {
   private Response junit;
   private Response dataChecks;
   private Response lineCoverage;
   private Response branchCoverage;
   private Response cpd;

    public Response getJunit() {
        return junit;
    }

    public void setJunit(Response junit) {
        this.junit = junit;
    }

    public Response getDataChecks() {
        return dataChecks;
    }

    public void setDataChecks(Response dataChecks) {
        this.dataChecks = dataChecks;
    }

    public Response getLineCoverage() {
        return lineCoverage;
    }

    public void setLineCoverage(Response lineCoverage) {
        this.lineCoverage = lineCoverage;
    }

    public Response getBranchCoverage() {
        return branchCoverage;
    }

    public void setBranchCoverage(Response branchCoverage) {
        this.branchCoverage = branchCoverage;
    }

    public Response getCpd() {
        return cpd;
    }

    public void setCpd(Response cpd) {
        this.cpd = cpd;
    }
}
