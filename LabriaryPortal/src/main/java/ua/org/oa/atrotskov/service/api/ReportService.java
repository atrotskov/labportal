package ua.org.oa.atrotskov.service.api;

import ua.org.oa.atrotskov.model.dto.ReportDTO;

/**
 * Created by jdev on 25.12.2015.
 */
public interface ReportService {
    public ReportDTO getReportById(long id);
    public boolean addReport(ReportDTO reportDTO);
    public boolean updateReport(ReportDTO reportDTO);
    public boolean deleteReport(ReportDTO reportDTO);
}
