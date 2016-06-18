package com.mobicare.wifi.cm.reports.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobicare.wifi.cm.reports.entity.ErrorReport;

@Repository
public interface ErrorReportRepository extends JpaRepository<ErrorReport, Integer> {
	List<ErrorReport> findByLoginOrderByEventDateDesc(String login, Pageable pageable);
}