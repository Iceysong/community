package life.majiang.community.community.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class GithubUser {
    private String id;
    private String name;
    private String user;
    private String bio;
    private String login;
    private String avatar_url;


}
