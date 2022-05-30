// SessionUser는 인증된 사용자 정보만 필요함.

package park.kyungdae.com.config.auth.dto;

import lombok.Getter;
import park.kyungdae.com.domain.user.User;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
