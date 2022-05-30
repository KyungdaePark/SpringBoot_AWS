package park.kyungdae.com.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); //Optional클래스는 여러 api를 제공->null이냐 아니냐에 따른 코딩 가능하게 해줌
}
