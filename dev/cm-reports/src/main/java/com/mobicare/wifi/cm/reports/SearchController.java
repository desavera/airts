package com.mobicare.wifi.cm.reports;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobicare.wifi.cm.reports.entity.ErrorReport;
import com.mobicare.wifi.cm.reports.entity.LoginReport;
import com.mobicare.wifi.cm.reports.repository.ErrorReportRepository;
import com.mobicare.wifi.cm.reports.repository.LoginReportRepository;

@RestController
public class SearchController {
    @Autowired
    private LoginReportRepository loginRepo;
    
    @Autowired
    private ErrorReportRepository errorRepo;

    @RequestMapping("/reports/login/{login}")
    public List<LoginReport> findLoginReports(@PathVariable(value="login") String login) {
    	Pageable topTen = new PageRequest(0, 10);
    	List<LoginReport> reports = loginRepo.findByLoginOrderByLogDateDesc(login, topTen);
        return reports;
    }
    
    @RequestMapping("/reports/error/{login}")
    public List<ErrorReport> findErrorReports(@PathVariable(value="login") String login) {
    	Pageable topTen = new PageRequest(0, 10);
    	List<ErrorReport> reports = errorRepo.findByLoginOrderByEventDateDesc(login, topTen);
        return reports;
    }
}
