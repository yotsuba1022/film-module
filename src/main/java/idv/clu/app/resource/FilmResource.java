package idv.clu.app.resource;

import idv.clu.app.model.Film;
import idv.clu.app.repository.FilmRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/films")
public class FilmResource {

    @Inject
    FilmRepository filmRepository;

    @GET
    @Path(("/{filmId}"))
    @Produces(MediaType.TEXT_PLAIN)
    public String getFilm(short filmId) {
        Optional<Film> film = filmRepository.getFilmById(filmId);
        return film.isPresent() ? film.get().getTitle() : "No film was found";
    }

    @GET
    @Path("/pagedFilms/{page}/{minLength}")
    @Produces(MediaType.TEXT_PLAIN)
    public String paged(long page, short minLength) {
        return filmRepository.paged(page, minLength)
                .map(f -> String.format("%s (%d min)", f.getTitle(), f.getLength()))
                .collect(Collectors.joining("\n"));
    }

    @GET
    @Path("/pagedFilms/{startsWith}/{minLength}")
    @Produces(MediaType.TEXT_PLAIN)
    public String actors(String startsWith, short minLength) {
        return filmRepository.actors(startsWith, minLength)
                .map(f -> String.format("%s (%d min): %s",
                        f.getTitle(),
                        f.getLength(),
                        f.getActors()
                                .stream()
                                .map(a -> String.format("%s %s", a.getFirstName(), a.getLastName()))
                                .collect(Collectors.joining(", "))
                ))
                .collect(Collectors.joining("\n"));
    }

    @PUT
    @Path("/update/{minLength}/{rentalRate}")
    @Produces(MediaType.TEXT_PLAIN)
    public String updateRentalRateAccordingToLength(short minLength, float rentalRate) {
        filmRepository.updateRentalRate(minLength, BigDecimal.valueOf(rentalRate));
        return filmRepository.getFilms(minLength)
                .map(f -> String.format("%s (%d min) - $%f"
                        , f.getTitle(), f.getLength(), f.getRentalRate()))
                .collect(Collectors.joining("\n"));
    }

}
