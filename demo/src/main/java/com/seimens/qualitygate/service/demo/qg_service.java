package com.seimens.qualitygate.service.demo;

import com.seimens.qualitygate.service.demo.entity.Branch;
import com.seimens.qualitygate.service.demo.entity.junit_test_result;
import com.seimens.qualitygate.service.demo.entity.status_response;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service
public class qg_service {
    public status_response get_status (String branch) throws ParserConfigurationException, IOException, SAXException {
       status_response s= new status_response();
        for(String s1: new String[]{"junit_test_result","datacheck_test_result","junit_branch_coverage","junit_line_coverage","cpd"})
        {
            File xmlFile;
            try {
                 xmlFile= new ClassPathResource("/static/data/"+branch+ "/"+s1 + "/gatestatus.xml").getFile();
                }
            catch(Exception e)
            {
                continue;
            }
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(xmlFile);
                String status = (doc.getElementsByTagName("status").item(0).getAttributes().getNamedItem("result").getTextContent());
                if (s1 == "junit_test_result") s.setJunit_test_status(status);
                else if (s1 == "datacheck_test_result") s.setDatacheck_test_status(status);
                else if (s1 == "junit_branch_coverage") s.setJunit_branch_coverage_status(status);
                else if (s1 == "junit_line_coverage") s.setJunit_line_coverage_status(status);
                else s.setCpd_status(status);
        }


        return s;
    }

    public junit_test_result get_junit_result(String option,String branch) throws IOException{

        junit_test_result res=new junit_test_result();

        for(String i: new String[]{"skipped.txt","tests.errors.txt","tests.failed.txt","tests.passed.txt","tests.intermittent.txt","tests.txt"})
        {    File file;
            try {
            file =
                    new ClassPathResource("/static/data/" + branch + "/" + option + "/" + i).getFile();
        }
        catch(Exception e)
        {
            return res;
        }
            Scanner sc = new Scanner(file);
            List<String> a=new ArrayList<String>();
            while(sc.hasNextLine()) {
                try {
                    a.add(sc.next());
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }

            if(i=="skipped.txt")res.setSkipped(a);
            else if(i=="tests.errors.txt")res.setErrors(a);
            else if(i=="tests.failed.txt")res.setFailed(a);
            else if(i=="tests.passed.txt")res.setPass(a);
            else if(i=="tests.intermittent.txt")res.setIntermittent(a);
            else if(i=="tests.txt")res.setRun(a);

        }
        return res;
    }
    public Branch get_branch_coverage(String branch) throws IOException {
        File file =
                new ClassPathResource("/static/data/"+branch+"/junit_branch_coverage/class-coverage.csv").getFile();
        Scanner sc = new Scanner(file);
        if(sc.hasNextLine())
            sc.nextLine();
        List<String> class_name=new ArrayList<>();
        List<String> lines_covered=new ArrayList<>();
        List<String> lines_valid=new ArrayList<>();
        List<String> branches_covered=new ArrayList<>();
        List<String> branches_valid=new ArrayList<>();
        List<String> complexity=new ArrayList<>();
       while(sc.hasNextLine())
       {
           String s=sc.nextLine();
           List<String>a= Arrays.asList(s.split(","));
           class_name.add(a.get(0));
           lines_covered.add(a.get(1));
           lines_valid.add(a.get(2));
           branches_covered.add(a.get(3));
           branches_valid.add(a.get(4));
           complexity.add(a.get(5));
       }

       Branch b=new Branch();
       b.setBranches_covered(branches_covered);
       b.setBranches_valid(branches_valid);
       b.setClass_name(class_name);
       b.setComplexity(complexity);
       b.setLines_covered(lines_covered);
       b.setLines_valid(lines_valid);
       return b;
    }
    public String get_cpd(String branch) throws IOException, ParserConfigurationException, SAXException {
        File xmlFile =
                new ClassPathResource("/static/data/"+branch+"/cpd/gatestatus.xml").getFile();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(xmlFile);
        String s=doc.getElementsByTagName("status").item(0).getAttributes().getNamedItem("details").getTextContent();
        return s;
    }
}
