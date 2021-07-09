package com.seimens.qualitygate.service.demo.controller;

import com.seimens.qualitygate.service.demo.Service.QgService;
import com.seimens.qualitygate.service.demo.entity.Coverage;
import com.seimens.qualitygate.service.demo.entity.JunitGateResult;
import com.seimens.qualitygate.service.demo.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import com.seimens.qualitygate.service.demo.entity.GateSummaryResponse;
@Controller
@RequestMapping("/qg")
public class QgController {
    @Autowired
    private QgService qgservice;

    @GetMapping("/{branchname}/junit/{test_category}")
    @ResponseBody
    public JunitGateResult getJunit(@PathVariable("branchname") String branch_name,@PathVariable("test_category") String cat) throws IOException {
        return qgservice.getJunitGateResult("junit_test_result",branch_name,cat);
    }
    @GetMapping("/{branchname}/datachecks/{test_category}")
    @ResponseBody
    public JunitGateResult getDatacheck(@PathVariable("branchname") String branch_name,@PathVariable("test_category") String cat) throws IOException {
        return qgservice.getJunitGateResult("datacheck_result",branch_name,cat);
    }

    @GetMapping("/{branchname}")
    @ResponseBody
    public GateSummaryResponse getStatusQg(@PathVariable("branchname") String branch_name) throws ParserConfigurationException, IOException, SAXException {
        return qgservice.getStatus(branch_name);
    }

    @GetMapping("{branchname}/coverage")
    @ResponseBody
    public Coverage getCoverage(@PathVariable("branchname") String branch) throws IOException {
        return qgservice.getBranchCoverage(branch);
    }

    @GetMapping("{branchname}/demo")
    @ResponseBody
    public Response demo(@PathVariable("branchname")String branch)
    {
        return qgservice.getDemo(branch);
    }
}
