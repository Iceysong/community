package life.majiang.community.community.controller;

import life.majiang.community.community.interfaces.ResponseResultBody;
import life.majiang.community.community.model.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@ResponseResultBody
@RequestMapping("/test")
public class ResultStatusTest {

    private static final HashMap<String, Object> INFO;

    static {
        INFO = new HashMap<>();
        INFO.put("name", "song");
        INFO.put("age", "70");
    }

    @GetMapping("/hello")
    public Map<String, Object> hello() {
        return INFO;
    }

    @GetMapping("/result")
    @ResponseBody
    public Result<Map<String, Object>> helloResult() {
        return Result.success(INFO);
    }

    @GetMapping("/error")
    public HashMap<String, Object> helloError() throws Exception {
        throw new Exception("helloError");
    }
}
