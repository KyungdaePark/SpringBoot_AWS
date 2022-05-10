package park.kyungdae.com.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import park.kyungdae.com.web.dto.HelloResponseDto;

@RestController //일반 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어줌
public class HelloController {

    @GetMapping("/hello") //Get요청을 받는 API를 만듬
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, //@RequestParm: 외부에서 @RequestParam("name")으로 넘긴 파라미터를 메소드 파라미터 String name에 저장
                                     @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
