//Database에 접근하는 PostsRepository 인터페이스의 save() 메소드를 이용해 database에 저장

package park.kyungdae.com.service.posts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import park.kyungdae.com.domain.posts.PostsRepository;
import park.kyungdae.com.web.dto.PostsSaveRequestDto;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
