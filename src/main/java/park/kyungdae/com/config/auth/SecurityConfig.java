package park.kyungdae.com.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import park.kyungdae.com.domain.user.Role;
@RequiredArgsConstructor
@EnableWebSecurity //Spring Security 설정들을 활성화해줌
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                //h2-console을 사용하기 위해 해당 기능들을 disable함
                .and()
                    .authorizeRequests()
                    //URL별 권한 관리 설정 시작, antMatchers 옵션을 사용하기 위함
                    .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    //antMatchers : URL,HTTP 메소드별로 권한 관리 대상을 지정할 수 있음.
                    //permitAll() : 전체 열람 권한을 줌
                    //hasRole : USER권한을 가진 사람만 접근할 수 있게 함.
                    .anyRequest().authenticated() //anyRequest, authenticated : 그 외 URL은 인증된 사용자, 즉 로그인한 사람만 사용가능하게 함
                .and()
                    .logout()
                    //logout 기능에 대한 여러 설정의 진입점임
                        .logoutSuccessUrl("/") //logout이 성공하면 / 주소로 이동
                .and()
                    .oauth2Login()
                    //OAuth2 로그인 기능에 대한 여러 설정의 진입접임.
                        .userInfoEndpoint()
                        // OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정을 담당함.
                            .userService(customOAuth2UserService);
                            //소셜 로그인 성공 이후 UserService 인터페이스의 구현체를 등록함.
                            //리소스 서버(소셜 서비스)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능 명시 가능(=customOAuth2UserSerivce)

    }
}
