package spx.baicai.model;

import org.beetl.sql.core.annotatoin.AutoID;
import java.io.Serializable;

public class User implements Serializable{
    @AutoID
    private Integer id ;
    //注册时间戳
    private Integer regTime ;
    private String email ;
    //手机号
    private String mobile ;
    //name
    private String name ;
    //密码
    private String password ;
    //加密盐值
    private String salt ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRegTime() {
        return regTime;
    }

    public void setRegTime(Integer regTime) {
        this.regTime = regTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
