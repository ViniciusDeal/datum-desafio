package support.api;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import support.domain.Usuario;

import static io.restassured.RestAssured.given;

public class UserApi {

    private static final String CREATE_USER_ENDPOINT = "/users";
    private static final String USER_ENDPOINT = "/users?page={page}";
    private static final String PUT_USER_ENDPOINT = "/users/{id}";
    private static final String DELETE_USER_ENDPOINT = "/users/{id}";

    public void createUser(Usuario user){
        given().
            body(user).
            contentType(ContentType.JSON).
        when().
            post(CREATE_USER_ENDPOINT).
        then().
            contentType(ContentType.JSON).
            statusCode(HttpStatus.SC_CREATED);
    }

    public void getUsers() {
        given().
            pathParam("page",2).
             contentType(ContentType.JSON).
        when().
            get(USER_ENDPOINT).
        then().
            contentType(ContentType.JSON).
            statusCode(HttpStatus.SC_OK);
    }

    public void updateUser(){
        given().
            pathParam("id",690).
            contentType(ContentType.JSON).
        when().
            put(PUT_USER_ENDPOINT).
        then().
            contentType(ContentType.JSON).
            statusCode(HttpStatus.SC_OK);
    }

    public void deleteUser(){
        given().
            pathParam("id",690).
        when().
            delete(DELETE_USER_ENDPOINT).
        then().
            statusCode(HttpStatus.SC_NO_CONTENT);
    }
}
