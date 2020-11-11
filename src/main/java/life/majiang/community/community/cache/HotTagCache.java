package life.majiang.community.community.cache;

import life.majiang.community.community.dto.HotTagDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Data
public class HotTagCache {
    private List<String> hots = new ArrayList<>();

    /**
     * 标签列表取最热前三
     * @param tags
     */
    public void updateTags(Map<String, Integer> tags) {
        int max = 3;
        PriorityQueue<HotTagDTO> priorityQueue = new PriorityQueue<>(max);
        tags.forEach((name,priority)->{
            HotTagDTO hotTagDTO = new HotTagDTO();
            hotTagDTO.setName(name);
            hotTagDTO.setPriority(priority);
            if (priorityQueue.size()<max){
                priorityQueue.add(hotTagDTO);
            }else {
                HotTagDTO min = priorityQueue.peek();//拿到最小的
                if (hotTagDTO.compareTo(min)>0){
                    priorityQueue.poll();//扔出最小的
                    priorityQueue.add(hotTagDTO);
                }
            }
        });

        List<String> sortedTags = new ArrayList<>();
        HotTagDTO poll = priorityQueue.poll();
        while (poll!=null){
            sortedTags.add(0,poll.getName());
            poll = priorityQueue.poll();
        }
        hots = sortedTags;
    }

}
