//등록, 수정, 삭제 기능을 하는 PostApiController


// 1. Dto는 정보만 가지고 있는 클래스이다.
// 2. 그래서 받아온 request들을 Dto로 바꿔서
// 3. postsService, 즉 서비스 클래스에 넘겨준다.
// 4. 이때 save/update/findbyid 메서드들은 각각의 기능에 맞는 형식으로 만들어진 Dto를 사용한다.

package park.kyungdae.com.web;

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
        System.out.println("PostApiController의 save메소드 실행");
        return postsService.save(requestDto);
        // PostsSaveRequestDto는 title, content, author 내용을 담고있다.
    }

    @PutMapping("api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
        // PostsUpdateRequestDto는 title, content 내용을 담고있다.
    }

    @GetMapping("api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        // PostsResponseDto는 title, cotent, author, "id"를 담고있다.
        // PostsResponseDto는 title, content, author, id를 얻기 위해서 Posts클래스의 db에 직접 접근한다.
        System.out.println("PostApiController의 findbyid메소드 실행");
        return postsService.findById(id);
    }

    @DeleteMapping("api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }

    // Application.java -> PostApiController 內 Post/Put/Get Mapping
    // 가져온 정보로 Service에서 실행
}
