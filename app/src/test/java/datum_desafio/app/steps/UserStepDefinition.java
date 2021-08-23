package datum_desafio.app.steps;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.apache.http.HttpStatus;
import support.api.UserApi;
import support.domain.Usuario;

import static io.restassured.RestAssured.given;

public class UserStepDefinition {

    private static final String CREATE_USER_ENDPOINT = "/users";
    private static final String USER_ENDPOINT = "/users?page={page}";

    private Usuario expectedUser;

    @Quando("crio um usuario")
    public void crioUmUsuaio() {
        expectedUser = Usuario.builder().build();

        UserApi userApi = new UserApi();
        userApi.createUser(expectedUser);
    }

    @Entao("os usuario sao retornados")
    public void osUsuarioSaoRetornados() {
        UserApi userApi = new UserApi();
        userApi.getUsers();
    }


}
