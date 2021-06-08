package hu.flowacademy.gyakorlatBands.service;

import hu.flowacademy.gyakorlatBands.enumPackage.Genre;
import hu.flowacademy.gyakorlatBands.model.Band;
import hu.flowacademy.gyakorlatBands.repository.BandsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BandsServiceTest {

    @InjectMocks
    private BandsService bandsService;

    @Mock
    private BandsRepository bandsRepository;

    @Test
    public void testSave() {
        Band expectedBand = givenValidBand();
        Band actualBand = whenSavingBand(expectedBand);
        assertEquals(expectedBand, actualBand);
    }

    private Band givenValidBand() {
        return Band.builder()
                .name("Beatles")
                .genre(Genre.POP)
                .build();
    }

    private Band whenSavingBand(Band expectedBand) {
        when(bandsRepository.save(any()))
                .thenReturn(expectedBand.toBuilder().build());
        return bandsService.save(
                expectedBand
        );
    }
}

