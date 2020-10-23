package life.majiang.community.community.controller;

import life.majiang.community.community.dto.AccessTokenDto;
import life.majiang.community.community.provider.GithubProvider;
import life.majiang.community.community.provider.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping(value = "/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletResponse response){
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setClient_id("a522d6f2f7a547084c43");
        accessTokenDto.setClient_secret("5b889e512df1dab58dbb601d54654bd77897998e");
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDto.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDto);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getLogin());
        return "index";
    }

}
