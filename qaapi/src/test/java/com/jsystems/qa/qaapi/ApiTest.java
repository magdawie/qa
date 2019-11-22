package com.jsystems.qa.qaapi;
import com.jsystems.qa.qaapi.model.User;
import com.jsystems.qa.qaapi.model.azure.author.AzureAuthor;
import com.jsystems.qa.qaapi.model.azure.book.Book;
import com.jsystems.qa.qaapi.service.azure.BookService;
import com.jsystems.qa.qaapi.service.user.UserService;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("ApiTest")
@DisplayName("Api test")
public class ApiTest {
    @Test
    @DisplayName("First api test")
    public void FirstApiTest() {
        RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6b69ec3100009d211b8aeb")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo("Piotr"))
                .body("surname", equalTo("Kowalski"));

    }

    @Test
    @DisplayName("Should returns list of users")
    public void shouldReturnsListOfUsers() {
        RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789{id}/asdasd/")
                .then()
                .assertThat()
                .statusCode(200)
                .body("[0].imie", notNullValue())
                .body("[0].imie", equalTo("Piotr"))
                .body("[0].nazwisko", notNullValue())
                .body("[0].nazwisko", equalTo("Kowalski"));
        //    .body("[0].device[0].device.model.produce", equalTo("dell"))) - bo nie dziala z kropkami nazwane, dla tegpo srednik dalej

    }

    @Test
    @DisplayName("Should returns list of users using jasonPath")
    public void jasonPathTest() {
        List<User> users = UserService.getUsers();
        assertTrue(users.get(0).imie.equals("Piotr"));
        assertTrue(users.get(0).nazwisko.equals("Kowalski"));
        assertTrue(users.get(0).device.get(0).type.equals("computer"));
        assertTrue(users.get(0).device.get(0).deviceModel.get(0).screenSize == 17);
        assertTrue(users.size() > 0);
    }

    @Test
    @Disabled
    public void shouldReturnAllAzureAuthorsList(){
        List<AzureAuthor> azureAuthors = UserService.getAzureAuthors();
        assertThat(azureAuthors.size()).isGreaterThan(0);

        for (AzureAuthor azureAuthor : azureAuthors) {
            int firstNameId = Integer.parseInt(azureAuthor.firstName.replace("First Name ", ""));
            assertThat(azureAuthor.firstName).contains("First Name ");
            assertThat(azureAuthor.firstName).matches("First Name \\d*");
            assertTrue(azureAuthor.id == firstNameId);
        }
    }

    @Test
    @DisplayName("Post Book test")
    public void   postBookTest(){
        Book book = new Book(1, "Jsystems", "Szkolenia", 382, "en", "2019-11-22T07:56:19.995Z");
        BookService.postBook(book, 200);
    }
}
