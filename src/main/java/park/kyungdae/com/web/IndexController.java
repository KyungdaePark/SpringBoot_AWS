package park.kyungdae.com.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index"; //앞의 경로와 뒤의 mustache확장자는 자동으로 붙여주므로 src/main/resources/templates/index.mustache를 반환하는 것과 같음.
    }

    @GetMapping("/posts/save")
    public String postSave(){
        return "posts-save";
    }
}
