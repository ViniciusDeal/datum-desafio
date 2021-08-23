package datum_desafio.app.steps;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.apache.http.HttpStatus;
import support.api.UserApi;
import support.domain.Usuario;

import static io.restassured.RestAssured.given;

public class UserStepDefinition {

    private UserApi userApi;

    public UserStepDefinition(){
        userApi = new UserApi();
    }

    private Usuario expectedUser;

    @Quando("crio um usuario")
    public void crioUmUsuaio() {
        expectedUser = Usuario.builder().build();
        userApi.createUser(expectedUser);
    }

    @E("os usuarios sao retornados")
    public void osUsuarioSaoRetornados() {
        userApi.getUsers();
    }

    @Entao("atualizo o usuario criado")
    public void atualizoOUsuarioCriado() {
        expectedUser.setName("usuario");
        expectedUser.setJob("dev");
        userApi.updateUser();

    }

    @E("deleto o usuario")
    public void deletoOUsuario() {
        userApi.deleteUser();
    }


}
