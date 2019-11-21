package com.jsystems.qa.qaapi;

import com.jsystems.qa.qaapi.model.User;
import io.restassured.RestAssured;

import java.util.List;

public class UserService {

    public List<User> getUsers(){
        return RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789{id}/asdasd/")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList("", User.class)
                ;

    }
}
