package life.majiang.community.community.provider;

import com.alibaba.fastjson.JSON;
import life.majiang.community.community.dto.AccessTokenDto;
import okhttp3.*;
import org.springframework.stereotype.Component;


import java.io.IOException;


@Component
public class GithubProvider {

    /**
     * 使用code获取token，post方式
     * @param accessTokenDto
     * @return
     */
    public String getAccessToken(AccessTokenDto accessTokenDto){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDto));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String token = string.split("&")[0].split("=")[1];
            System.out.println(string);
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + "d65042f3ba7a04e68af96d3089b55e859d32bcc2")
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            //TODO
            //返回错误提示：{"message":"Bad credentials","documentation_url":"https://docs.github.com/rest"}
            //应该是获取的access_token无效
            //网页访问https://api.github.com/user?access_token=e819546c9588b30904517052f65a925741d8a950
            System.out.println(string);
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



}
