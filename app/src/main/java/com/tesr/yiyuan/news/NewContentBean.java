package com.tesr.yiyuan.news;

public class NewContentBean {
    private String title;
    private String url;
    private String source;
    private String time;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "NewContentBean{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", source='" + source + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
