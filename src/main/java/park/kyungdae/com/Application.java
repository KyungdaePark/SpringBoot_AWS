package park.kyungdae.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // Jpa Auditing 활성화
@SpringBootApplication //스프링 부트의 자동 설정, 읽기와 생성을 모두 자동으로 설정함. -> 여기서부터 읽기 때문에 프로젝트 상단에 있어야 함.
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args); //SpringApplication.run() 메소드로 내장 WAS 실행
    }
}
