package datum_desafio.app.steps;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import support.domain.Usuario;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class UserStepDefinition {

    private static final String CREATE_USER_ENDPOINT = "/users";
    private static final String USER_ENDPOINT = "/users?page={page}";

    private Usuario user;

    @Quando("faco um post para {word} com os dados:")
    public void facoUmPostParaApiUsersComOsDados(String endpoint, Map<String, String> user) {
        given().
            body(user).
        when().
            post(endpoint).
        then().
            statusCode(HttpStatus.SC_CREATED);
    }

    @Entao("faco um get para {word} com todos os usuarios")
    public void facoUmGetParaApiUsersPageComTodosOsUsuarios(String endpoint) {
        when().
           get(endpoint).
        then().
           statusCode(HttpStatus.SC_OK);
    }

    @Quando("crio um usuario")
    public void crioUmUsuaio() {
        user = Usuario.builder().build();

        given().
            body(user).
        when().
            post(CREATE_USER_ENDPOINT).
        then().
            statusCode(HttpStatus.SC_CREATED);
    }

    @Entao("os usuario sao retornados")
    public void osUsuarioSaoRetornados() {
        given().
            pathParam("page",2).
        when().
            get(USER_ENDPOINT).
        then().
            statusCode(HttpStatus.SC_OK);
    }
}
