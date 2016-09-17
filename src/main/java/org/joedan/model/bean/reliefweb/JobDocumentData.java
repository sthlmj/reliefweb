package org.joedan.model.bean.reliefweb;

import java.util.Set;

public class JobDocumentData {

    private String href;

    private int time;

    private int totalCount;

    private int count;

    private Set<JobData> data;

    public Set<JobData> getData() {
        return data;
    }

    public void setData(Set<JobData> data) {
        this.data = data;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
