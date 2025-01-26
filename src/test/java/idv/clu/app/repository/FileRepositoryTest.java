package idv.clu.app.repository;

import idv.clu.app.model.Film;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
public class FileRepositoryTest {

    @Inject
    FilmRepository filmRepository;

    @Test
    public void testGetFilms() {
        Optional<Film> film = filmRepository.getFilmById((short) 10);
        assertTrue(film.isPresent());
        assertEquals("ALADDIN CALENDAR", film.get().getTitle());
    }

}
