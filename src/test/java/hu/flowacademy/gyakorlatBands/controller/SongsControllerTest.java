package hu.flowacademy.gyakorlatBands.controller;

import hu.flowacademy.gyakorlatBands.enumPackage.Genre;
import hu.flowacademy.gyakorlatBands.model.Album;
import hu.flowacademy.gyakorlatBands.model.Band;
import hu.flowacademy.gyakorlatBands.repository.AlbumRepository;
import hu.flowacademy.gyakorlatBands.repository.BandsRepository;
import hu.flowacademy.gyakorlatBands.repository.SongsRepository;
import io.restassured.http.ContentType;
import hu.flowacademy.gyakorlatBands.model.Songs;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static io.restassured.RestAssured.given;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class SongsControllerTest {

    @Autowired
    BandsRepository bandsRepository;

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SongsRepository songsRepository;

    private void insert() {
        var saveBand = bandsRepository.saveAll(List.of(
                Band.builder().name("Beatles").genre(Genre.POP).build(),
                Band.builder().name("Eminem").genre(Genre.RAP).build(),
                Band.builder().name("Korn").genre(Genre.ROCK).build(),
                Band.builder().name("Slipknot").genre(Genre.ROCK).build()
        ));

        var saveAlbums = albumRepository.saveAll(List.of(
                Album.builder().title("Album cím").releaseDate("1999").band(saveBand.get(0)).build(),
                Album.builder().title("Album cím2").releaseDate("2001").band(saveBand.get(0)).build(),
                Album.builder().title("Album cím3").releaseDate("2004").band(saveBand.get(0)).build(),
                Album.builder().title("Album cím4").releaseDate("2007").band(saveBand.get(1)).build(),
                Album.builder().title("Album cím5").releaseDate("2010").band(saveBand.get(1)).build()
        ));

        songsRepository.saveAll(List.of(
                Songs.builder().songTitle("Szám címe").length(3.4).licencePrice(2000).album(saveAlbums.get(0)).build(),
                Songs.builder().songTitle("Szám címe2").length(5.6).licencePrice(3500).album(saveAlbums.get(0)).build(),
                Songs.builder().songTitle("Szám címe3").length(2.6).licencePrice(1500).album(saveAlbums.get(1)).build()
        ));
    }

    @Test
    public void testCreateSong() {
        insert();
        createSong(albumRepository.findAll().get(0));
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
    public void testGetAllSongs() {
        insert();
        when().get("/api/songs").then()
                .statusCode(200)
                .body("size()", is(3));
    }

    @Test
    public void testDeleteSong() {
        insert();
        Songs song = createSong(albumRepository.findAll().get(0));
        given()
                .when()
                .delete("/api/songs/" + song.getId())
                .then()
                .assertThat()
                .statusCode(202);
    }
}