import dto.TokenDto;
import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.junit.jupiter.api.BeforeEach;
import services.AuthUserService;
import services.BaseApiService;

public class BaseTest {

    protected AuthUserService authUserService;
    protected TokenDto token;

    @BeforeEach
    public void setUp(){
        authUserService = new AuthUserService();
    }

    protected <T extends BaseApiService> T getAuthorizedService(Class<T> clazz, TokenDto token) {
        T service;
        try {
            service = ConstructorUtils.invokeConstructor(clazz, token);
        } catch (Exception e) {
            throw new RuntimeException(
                    String.format("Could not create '%s' service with token!", clazz.getSimpleName()));
        }
        return service;
    }
}
