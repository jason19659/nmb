package pw.jason19659.nmb.model;

import java.util.Date;
import java.util.UUID;

public class User {
    private String id;

    private String password;

    private Date pubDate;
    
    public User generateUser() {
		this.id = UUID.randomUUID().toString();
		this.password = UUID.randomUUID().toString();
		this.pubDate = new Date();
		return this;
	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }
    
    /* 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return id+";"+password;
    }
}

  