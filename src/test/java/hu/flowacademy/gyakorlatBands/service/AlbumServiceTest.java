package hu.flowacademy.gyakorlatBands.service;

import hu.flowacademy.gyakorlatBands.exception.ValidateException;
import hu.flowacademy.gyakorlatBands.model.Album;
import hu.flowacademy.gyakorlatBands.model.Band;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class AlbumServiceTest {

    @InjectMocks
    private AlbumService albumService;

    public Band band = Band.builder().build();

    @Test
    public void testSaveValidateFailing() {
        assertThrows(ValidateException.class,
                () -> albumService.save(
                        giveAlbumWithoutTitle()
                        , band.getId()));
        assertThrows(ValidateException.class,
                () -> albumService.save(
                        giveAlbumWithoutReleaseDate()
                        , band.getId()));
    }

    private Album giveAlbumWithoutTitle() {
        return Album.builder()
                .releaseDate("1999")
                .build();
    }

    private Album giveAlbumWithoutReleaseDate() {
        return Album.builder()
                .title("Album címe")
                .build();
    }
}