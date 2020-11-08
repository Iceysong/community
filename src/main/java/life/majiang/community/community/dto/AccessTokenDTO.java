package life.majiang.community.community.dto;

import lombok.Data;

/**
 * 获取access token 需要传递的参数
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
