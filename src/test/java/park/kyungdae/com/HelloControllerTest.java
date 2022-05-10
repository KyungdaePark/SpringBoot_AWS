package park.kyungdae.com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import park.kyungdae.com.web.HelloController;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) //실행자 JUnit와 실행자 SpringRunner를 연결함
@WebMvcTest(controllers = HelloController.class) //Web(Spring MVC)에 집중할 수 있는 스프링 테스트 어노테이션

public class HelloControllerTest {

    @Autowired //스프링이 관리하는 Bean을 주입받음
    private MockMvc mvc; //웹 api를 테스트할때 사용

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) //MockMvc를 통해 /hello로 get요청을 함.
                .andExpect(status().isOk()) //200인지 아닌지
                .andExpect(content().string(hello)); //리턴값이 hello인지?
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                    get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) //$를 기준으로 필드명으 명시
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
