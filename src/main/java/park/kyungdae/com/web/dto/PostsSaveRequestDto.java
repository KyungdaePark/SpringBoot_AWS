//Request/Response 역할을 해줌
//Entity 클래스와 유사하지만 절대로 Entity클래스로 Request/Response 처리를 해서는 안됨
//Entity는 데이터베이스와 직접적으로 맞닿아 있기 때문임.
//그래서 toEntity()메서드를 이용해 간접적으로 처리해 Posts클래스(Entity)에 처리함
package park.kyungdae.com.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import park.kyungdae.com.domain.posts.Posts;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;
    @Builder
    public PostsSaveRequestDto(String title, String content, String author){ //생성자
        System.out.println("PostsSaveRequestDto 실행");
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
