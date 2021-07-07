package com.seimens.qualitygate.service.demo;

import com.seimens.qualitygate.service.demo.entity.Branch;
import com.seimens.qualitygate.service.demo.entity.junit_test_result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import com.seimens.qualitygate.service.demo.entity.status_response;
@Controller
@RequestMapping("/qg")
public class QgRouter {
    @Autowired
    private qg_service qgservice;

    @GetMapping("/{branchname}/junit")
    @ResponseBody
    public junit_test_result get_junit(@PathVariable("branchname") String branch_name) throws IOException {
        return qgservice.get_junit_result("junit_test_result",branch_name);
    }
    @GetMapping("/{branchname}/datachecks")
    @ResponseBody
    public junit_test_result get_datacheck(@PathVariable("branchname") String branch_name) throws IOException {
        return qgservice.get_junit_result("datacheck_result",branch_name);
    }

    @GetMapping("/{branchname}/status")
    @ResponseBody
    public status_response status_qg(@PathVariable("branchname") String branch_name) throws ParserConfigurationException, IOException, SAXException {
        return qgservice.get_status(branch_name);
    }

    @GetMapping("{branchname}/coverage")
    @ResponseBody
    public Branch get_coverage(@PathVariable("branchname") String branch) throws IOException {
        return qgservice.get_branch_coverage(branch);
    }
    @GetMapping("{branchname}/cpd")
    @ResponseBody
    public String get_cpd(@PathVariable("branchname") String branch) throws IOException, ParserConfigurationException, SAXException {
        return qgservice.get_cpd(branch);
    }
}
