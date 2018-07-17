package cn.ctcc.module.user1.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: zhangkui
 * @Date: 2018/7/13 11:29
 * @Description:用户实体
 */
public class User implements Serializable {

    private static final long serialVersionUID = -8131610168643194817L;
    private Long id;//id
    private String username;//用户名
    private String password;//用户密码
    private String phone;//用户电话
    private String email;//用户邮箱
    private Date created;//创建时间
    private Date updated;//修改时间

    public User(Long id, String username, String password, String phone, String email, Date created, Date updated) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.created = created;
        this.updated = updated;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }


    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "TbUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

}
