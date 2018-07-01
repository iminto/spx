package spx.baicai.model;

import org.beetl.sql.core.TailBean;

public class UserInfo extends TailBean {
    private Integer id ;
    //用户ID
    private Integer userId ;
    //联系方式
    private String address ;

    public Integer getId() {
        return id;
    }

    public UserInfo() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
