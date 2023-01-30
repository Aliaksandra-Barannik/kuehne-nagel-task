package mappers;

import dto.requests.LoginRequest;
import enums.User;

public class LoginRequestMapper {

    public static LoginRequest toLoginRequest(User user) {
        return new LoginRequest.Builder().withUserName(user.getName()).withPassword(user.getPassword()).build();
    }
}
