package ua.org.oa.atrotskov.model.dto;

import ua.org.oa.atrotskov.model.entity.Report;
import ua.org.oa.atrotskov.model.entity.User;

import java.util.List;

/**
 * Created by jdev on 03.12.2015.
 */
public class BookDTO {
    private long id;
    private String title;
    private String author;
    private int count;
    private List<User> users;
    private List<Report> reports;

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", count=" + count +
                ", users=" + users +
                ", reports=" + reports +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
}
