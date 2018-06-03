package spx.baicai.model;
import org.beetl.sql.core.TailBean;

public class User extends TailBean {
    private Integer id;
    private String name;
    private Integer role;//虚拟属性，表中不存在

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
