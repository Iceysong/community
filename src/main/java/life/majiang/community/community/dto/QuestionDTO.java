package life.majiang.community.community.dto;

import life.majiang.community.community.model.User;
import lombok.Data;

/**
 * @author song
 */
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
    private String description;
    private User user;

}
