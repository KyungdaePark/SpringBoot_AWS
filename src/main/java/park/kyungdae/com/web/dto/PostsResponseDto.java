//PostsResponseDto는 Entity의 필드 중 일부 만 사용 -> 생성자로 Entity를 받아 필드에 값을 넣음.

package park.kyungdae.com.web.dto;

import lombok.Getter;
import park.kyungdae.com.domain.posts.Posts;

@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    private String createdDate;
//    public PostsResponseDto(Posts entity){
//        System.out.println("PostsResponeDto의 생성자 실행");
//        this.id = entity.getId();
//        this.title = entity.getTitle();
//        this.content = entity.getContent();
//        this.author = entity.getAuthor();
//    }
public PostsResponseDto(Posts entity){
    System.out.println("PostsResponeDto_with createdDate의 생성자 실행");
    this.id = entity.getId();
    this.title = entity.getTitle();
    this.content = entity.getContent();
    this.author = entity.getAuthor();
    this.createdDate = String.valueOf(entity.getCreatedDate());
}
}
