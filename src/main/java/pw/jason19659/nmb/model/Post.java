package pw.jason19659.nmb.model;

import java.util.Date;

public class Post {
    private String id;

    private String pid;

    private Integer sectionId;

    private String userId;

    private String title;

    private String content;

    private String image;

    private Date pubdate;
    

    public Post(String pid, Integer sectionId, String userId, String title, String content, String image, Date pubdate) {
		super();
		this.pid = pid;
		this.sectionId = sectionId;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.image = image;
		this.pubdate = pubdate;
	}
    
    public Post(){
    	
    }

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }
    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

}