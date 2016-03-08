package ua.org.oa.atrotskov.dao.api;

import ua.org.oa.atrotskov.model.entity.Book;
import ua.org.oa.atrotskov.model.entity.Report;
import ua.org.oa.atrotskov.model.entity.User;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jdev on 29.11.2015.
 */
public interface ReportDAO {
    public boolean addReport(Report report);
    public Report getReportById(long id);
    public boolean updateReport(Report report);
    public boolean deleteReportById(long id);

    public ArrayList<Report> getReportsByDate(Date date);
    public ArrayList<Report> getReportsByUser(User user);
    public ArrayList<Report> getReportsByBook(Book book);
}
