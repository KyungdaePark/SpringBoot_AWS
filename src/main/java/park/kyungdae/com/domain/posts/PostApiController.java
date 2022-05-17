//등록, 수정, 삭제 기능을 하는 PostApiController

package park.kyungdae.com.domain.posts;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import park.kyungdae.com.service.posts.PostsService;
import park.kyungdae.com.web.dto.PostsSaveRequestDto;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostsService postsService;

    @PostMapping("api/v1/posts")
    public long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }
}
