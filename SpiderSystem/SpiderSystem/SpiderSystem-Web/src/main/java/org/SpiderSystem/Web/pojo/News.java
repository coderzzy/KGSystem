package org.SpiderSystem.Web.pojo;

public class News {
    private Integer id;

    private String title;

    private String time;

    private String url;

    private String content;
    
	public News(){
			
	}
	
	public News(int newsId,String title,String content,String time,String url){
		this.id = newsId;
		this.title = title;
		this.content = content;
		this.time = time;
		this.url = url;
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}