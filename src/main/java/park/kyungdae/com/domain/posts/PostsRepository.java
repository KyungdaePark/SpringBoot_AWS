// Posts클래스로 Database를 접근하게 해줄 JpaRepository 생성
// 이 레포지토리는 Posts클래스 즉, Entity 클래스와 함께 위치해야 함
// 나중에 규모가 커져 도메인별로 프로젝트를 분리해야 한다면, 같이 움직여야 하기 때문에 하나의 패키지 內에서 관리함

package park.kyungdae.com.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    //JpaRepository<Entity클래스, PK타입>
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

}
