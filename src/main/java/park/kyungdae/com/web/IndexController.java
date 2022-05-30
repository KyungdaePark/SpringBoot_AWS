package park.kyungdae.com.web;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import park.kyungdae.com.service.posts.PostsService;
import park.kyungdae.com.web.dto.PostsResponseDto;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc()); //Model : 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있게함
        // 여기서는 postsService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달함.
        return "index"; //앞의 경로와 뒤의 mustache확장자는 자동으로 붙여주므로 src/main/resources/templates/index.mustache를 반환하는 것과 같음.
    }

    @GetMapping("/posts/save")
    public String postSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model){
        //PostsResponseDto dto = postsService.findById(id);
        //model.addAttribute("posts", dto);
        model.addAttribute("posts", postsService.findById(id));

        return "posts-update";
    }


}
