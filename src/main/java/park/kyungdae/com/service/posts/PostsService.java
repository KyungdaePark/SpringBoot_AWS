//Database에 접근하는 PostsRepository 인터페이스의 save() 메소드를 이용해 database에 저장

package park.kyungdae.com.service.posts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import park.kyungdae.com.domain.posts.Posts;
import park.kyungdae.com.domain.posts.PostsRepository;
import park.kyungdae.com.web.dto.PostsListResponseDto;
import park.kyungdae.com.web.dto.PostsResponseDto;
import park.kyungdae.com.web.dto.PostsSaveRequestDto;
import park.kyungdae.com.web.dto.PostsUpdateRequestDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional(readOnly = true) // 트랜잭션 범위는 유지, 조회기능만 있어서 조회 속도가 개선됨 -> 등록,수정,삭제 기능이 없는 서비스 메소드에서 사용하면 좋음
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)//.map(posts->new PostsListResponseDto(posts))와 같은 기능, postsRepository 결과로 넘어온 Posts의 Stream을
                                               // map을 통해 PostsListResponseDto 변환 -> List로 반환하는 메소드
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id=" +id));

        postsRepository.delete(posts);
    }

}
