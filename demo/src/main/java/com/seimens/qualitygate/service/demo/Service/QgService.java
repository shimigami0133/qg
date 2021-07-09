package com.seimens.qualitygate.service.demo.Service;

import com.seimens.qualitygate.service.demo.entity.Coverage;
import com.seimens.qualitygate.service.demo.entity.JunitGateResult;
import com.seimens.qualitygate.service.demo.entity.Response;
import com.seimens.qualitygate.service.demo.entity.GateSummaryResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service
public class QgService {
    @Autowired
    private RestTemplate restTemplate;
    public GateSummaryResponse getStatus(String branch) throws ParserConfigurationException, IOException, SAXException {
        GateSummaryResponse res=new GateSummaryResponse();
        for (String s1 : new String[]{"junit_test_result", "datacheck_test_result", "junit_branch_coverage", "junit_line_coverage", "cpd"}) {
            Response s = new Response();
            File xmlFile;

                xmlFile = new File("C:\\Users\\akondare\\Desktop\\dir\\" + branch + "\\" + s1 + "\\gatestatus.xml");
            if(!xmlFile.exists())continue;
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            String name=(doc.getElementsByTagName("gate").item(0).getAttributes().getNamedItem("name").getTextContent());
            String mode=(doc.getElementsByTagName("gate").item(0).getAttributes().getNamedItem("mode").getTextContent());
            String result=(doc.getElementsByTagName("status").item(0).getAttributes().getNamedItem("result").getTextContent());
            String details=(doc.getElementsByTagName("status").item(0).getAttributes().getNamedItem("details").getTextContent());
            String startTime=(doc.getElementsByTagName("timing").item(0).getAttributes().getNamedItem("starttime").getTextContent());
            String endTime=(doc.getElementsByTagName("timing").item(0).getAttributes().getNamedItem("endtime").getTextContent());

            s.setDetails(details);
            s.setEndTime(endTime);
            s.setMode(mode);
            s.setName(name);
            s.setStartTime(startTime);
            s.setResult(result);

            if(s==null)continue;
            else if(s1=="junit_test_result")
                res.setJunit(s);
            else if(s1=="datacheck_test_result")
                res.setDataChecks(s);
            else if(s1=="junit_branch_coverage")
                res.setBranchCoverage(s);
            else if(s1=="junit_line_coverage")
                res.setLineCoverage(s);
            else if(s1=="cpd")
                res.setCpd(s);
        }


        return res;
    }

    public JunitGateResult getJunitGateResult(String option, String branch,String cat) throws IOException {

        JunitGateResult res = new JunitGateResult();
            File file;

                file =
                        new File("C:\\Users\\akondare\\Desktop\\dir\\" + branch + "/" + option + "/" + cat+".txt");
            if(!file.exists()) return null;
            Scanner sc = new Scanner(file);
            List<String> a = new ArrayList<String>();
            while (sc.hasNextLine()) {
                try {
                    a.add(sc.next());
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            res.setListOfTests(a);
        return res;
    }

    public Coverage getBranchCoverage(String branch) throws IOException {
        File file =
                new File("C:\\Users\\akondare\\Desktop\\dir\\" + branch + "/junit_branch_coverage/class-coverage.csv");
        Scanner sc = new Scanner(file);
        if (sc.hasNextLine())
            sc.nextLine();
        List<String> class_name = new ArrayList<>();
        List<String> lines_covered = new ArrayList<>();
        List<String> lines_valid = new ArrayList<>();
        List<String> branches_covered = new ArrayList<>();
        List<String> branches_valid = new ArrayList<>();
        List<String> complexity = new ArrayList<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            List<String> a = Arrays.asList(s.split(","));
            class_name.add(a.get(0));
            lines_covered.add(a.get(1));
            lines_valid.add(a.get(2));
            branches_covered.add(a.get(3));
            branches_valid.add(a.get(4));
            complexity.add(a.get(5));
        }

        Coverage b = new Coverage();
        b.setBranchesCovered(branches_covered);
        b.setBranchesValid(branches_valid);
        b.setClassName(class_name);
        b.setComplexity(complexity);
        b.setLinesCovered(lines_covered);
        b.setLinesValid(lines_valid);
        return b;
    }

    public Response getDemo(String branch)
    {
       Response s=restTemplate.getForObject("http://ies-iesd-qgweb.ies.mentorg.com:8080/qualitygates/wa/SKIPLIST-2019.1_INT/junit_test_result/gatestatus.xml",
               Response.class);
        return s;
    }
}
