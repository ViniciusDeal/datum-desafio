package datum_desafio.app.config;

import io.cucumber.java.Before;
import io.restassured.RestAssured;


public class Config {

    @Before
    public void setup(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";
    }
}
