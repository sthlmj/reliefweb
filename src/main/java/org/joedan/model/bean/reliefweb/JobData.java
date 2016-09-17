package org.joedan.model.bean.reliefweb;

public class JobData {

    private int id;

    private String href;

    private JobDataFields fields;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JobDataFields getFields() {
        return fields;
    }

    public void setFields(JobDataFields fields) {
        this.fields = fields;
    }
}
