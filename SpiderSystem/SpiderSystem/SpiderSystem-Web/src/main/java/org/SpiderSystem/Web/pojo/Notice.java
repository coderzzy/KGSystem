package org.SpiderSystem.Web.pojo;

public class Notice {
    private Integer id;

    private String text;
    
    public Notice(){
    	
    }
    
    public Notice(int noticeId,String noticeText){
    	this.id = noticeId;
    	this.text = noticeText;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }
}