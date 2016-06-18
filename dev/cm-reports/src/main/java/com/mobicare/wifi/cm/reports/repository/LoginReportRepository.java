package com.mobicare.wifi.cm.reports.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobicare.wifi.cm.reports.entity.LoginReport;

@Repository
public interface LoginReportRepository extends JpaRepository<LoginReport, Integer> {
	List<LoginReport> findByLoginOrderByLogDateDesc(String login, Pageable pageable);
}
