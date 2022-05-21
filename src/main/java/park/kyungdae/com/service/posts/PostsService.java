//Database에 접근하는 PostsRepository 인터페이스의 save() 메소드를 이용해 database에 저장

package park.kyungdae.com.service.posts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import park.kyungdae.com.domain.posts.Posts;
import park.kyungdae.com.domain.posts.PostsRepository;
import park.kyungdae.com.web.dto.PostsResponseDto;
import park.kyungdae.com.web.dto.PostsSaveRequestDto;
import park.kyungdae.com.web.dto.PostsUpdateRequestDto;

import javax.transaction.Transactional;
// Transactional 은 전체 작업 중 하나라도 오류가 발생한다면 모든 작업을 취소한다. 보통 DB와 관련된 작업에서 사용함.

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        System.out.println("PostService의 save메소드 실행");
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id=" +id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        System.out.println("PostService의 findbyid메소드 실행");
        Posts entity = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id=" +id));
        return new PostsResponseDto(entity);
    }
}
