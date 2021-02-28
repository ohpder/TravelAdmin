package cn.hnjdzy.traveladmin.domain;

public class AdminInfo {
    private Integer id;//管理员id
    private String username;//管理员用户名
    private String password;//管理员密码
    private String Role;//管理员角色

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
