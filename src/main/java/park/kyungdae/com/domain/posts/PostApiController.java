//등록, 수정, 삭제 기능을 하는 PostApiController

package park.kyungdae.com.domain.posts;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import park.kyungdae.com.service.posts.PostsService;
import park.kyungdae.com.web.dto.PostsResponseDto;
import park.kyungdae.com.web.dto.PostsSaveRequestDto;
import park.kyungdae.com.web.dto.PostsUpdateRequestDto;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostsService postsService;

    @PostMapping("api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
