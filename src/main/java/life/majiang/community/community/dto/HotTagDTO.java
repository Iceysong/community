package life.majiang.community.community.dto;

import lombok.Data;

/**
 * song
 */
@Data
public class HotTagDTO implements Comparable {
    private String name;
    private Integer priority;

    @Override
    public int compareTo(Object o) {
        return this.getPriority() - ((HotTagDTO) o).getPriority();
    }
}
