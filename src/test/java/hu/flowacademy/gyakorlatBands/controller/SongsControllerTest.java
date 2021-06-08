package hu.flowacademy.gyakorlatBands.controller;

import hu.flowacademy.gyakorlatBands.model.Album;
import io.restassured.http.ContentType;
import hu.flowacademy.gyakorlatBands.model.Songs;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static io.restassured.RestAssured.given;

@ExtendWith(SpringExtension.class)
class SongsControllerTest {

    public Album album = Album.builder().id(2).build();

    @Test
    public void testCreateSong() {
        createSong(album);
    }

    private Songs createSong(Album album) {
        String title = "Szám címe";
        double length = 3.4;
        int licencePrice = 5000;

        return given()
                .body(Songs.builder().songTitle(title).length(length).licencePrice(licencePrice).album(album).build()
                )
                .contentType(ContentType.JSON)
                .when()
                .post("/api/songs/add/" + album.getId())
                .then()
                .assertThat()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("songTitle", equalTo(title))
                .body("length", equalTo((float) length))
                .body("licencePrice", equalTo(licencePrice))
                .and()
                .extract().body().as(Songs.class);
    }

    @Test
    public void testDeleteSong() {
        Songs song = createSong(album);
        given()
                .when()
                .delete("/api/songs/" + song.getId())
                .then()
                .assertThat()
                .statusCode(202);
    }
}