package park.kyungdae.com.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 클래스 내 모든 필드의 Getter 메소드 자동생성

@NoArgsConstructor // 기본 생성자 자동 추가
@Entity // 테이블과 링크될 클래스임을 알려줌 : 'posts' 테이블을 만듬
// @Entity 에서는 Setter 메소드를 절대 만들지 않음 (나중에 기능 바꿀때 복잡해짐)
public class Posts {

    @Id // 테이블의 PK(Primary Key) 필드를 나타냄.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment로 pk 필드를 만들거임
    private Long id;

    @Column(length=500, nullable = false) // 원래 안해도 됨(기본값이 column임), 근데 VARCHAR(255)의 길이를 500으로 늘리고 싶어서 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) // 타입을 TEXT로 변경하고 싶음
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
