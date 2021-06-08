package hu.flowacademy.gyakorlatBands.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import hu.flowacademy.gyakorlatBands.enumPackage.Genre;
import hu.flowacademy.gyakorlatBands.model.Band;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static io.restassured.RestAssured.given;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class BandsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void getExample() throws Exception {
        mockMvc.perform(get("/api/bands"))
                .andExpect(status().isOk());
    }

    @Test
    void postExample() throws Exception {
        var body = new Band();
        body.setName("Beatles");
        body.setGenre(Genre.POP);
        String jsonString = mapper.writeValueAsString(body);
        mockMvc.perform(post("/api/bands").contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetAllBands() {
        given().when()
                .get("/api/bands")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }
}