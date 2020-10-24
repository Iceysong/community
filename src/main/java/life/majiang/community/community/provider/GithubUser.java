package life.majiang.community.community.provider;

import org.springframework.stereotype.Component;

@Component
public class GithubUser {
    private String id;
    private String name;
    private String user;
    private String bio;
    private String login;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "GithubUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", user='" + user + '\'' +
                ", bio='" + bio + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
