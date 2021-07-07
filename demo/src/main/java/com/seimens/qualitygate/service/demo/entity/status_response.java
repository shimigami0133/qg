package com.seimens.qualitygate.service.demo.entity;
public class status_response{
    private String junit_test_status;
    private String cpd_status;
    private String junit_branch_coverage_status;
    private String junit_line_coverage_status;
    private String datacheck_test_status;

    public String getJunit_test_status() {
        return junit_test_status;
    }

    public void setJunit_test_status(String junit_test_status) {
        this.junit_test_status = junit_test_status;
    }

    public String getCpd_status() {
        return cpd_status;
    }

    public void setCpd_status(String cpd_status) {
        this.cpd_status = cpd_status;
    }

    public String getJunit_branch_coverage_status() {
        return junit_branch_coverage_status;
    }

    public void setJunit_branch_coverage_status(String junit_branch_coverage_status) {
        this.junit_branch_coverage_status = junit_branch_coverage_status;
    }

    public String getJunit_line_coverage_status() {
        return junit_line_coverage_status;
    }

    public void setJunit_line_coverage_status(String junit_line_coverage_status) {
        this.junit_line_coverage_status = junit_line_coverage_status;
    }

    public String getDatacheck_test_status() {
        return datacheck_test_status;
    }

    public void setDatacheck_test_status(String datacheck_test_status) {
        this.datacheck_test_status = datacheck_test_status;
    }
}
