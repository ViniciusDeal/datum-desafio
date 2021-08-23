package support.api;

import org.apache.http.HttpStatus;
import support.domain.Usuario;

import static io.restassured.RestAssured.given;

public class UserApi {

    private static final String CREATE_USER_ENDPOINT = "/users";
    private static final String USER_ENDPOINT = "/users?page={page}";

    public void createUser(Usuario user){
        given().
             body(user).
        when().
             post(CREATE_USER_ENDPOINT).
        then().
             statusCode(HttpStatus.SC_CREATED);
    }

    public void getUsers() {
        given().
                pathParam("page",2).
                when().
                get(USER_ENDPOINT).
                then().
                statusCode(HttpStatus.SC_OK);
    }
}
