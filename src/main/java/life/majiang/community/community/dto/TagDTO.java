package life.majiang.community.community.dto;

import lombok.Data;

import java.util.List;

/**
 * song
 */
@Data
public class TagDTO {
    private String categoryName;
    private List<String> tags;
}
