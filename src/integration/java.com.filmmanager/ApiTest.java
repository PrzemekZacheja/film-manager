import com.filmmanager.FilmManagerApplication;
import com.filmmanager.domain.filmreceiver.FilmFacade;
import com.filmmanager.domain.filmreceiver.dto.FilmResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = FilmManagerApplication.class)
public class ApiTest {

    @Autowired
    FilmFacade filmFacade;

    @Test
    void make_simple_request_to_foreign_api() {
        String title = "Avatar";
        FilmResponseDto filmResponseDto = filmFacade.fetchFilmByTitle(title);
        assertThat(filmResponseDto).isNotNull();
        assertThat(filmResponseDto.title()).isEqualTo(title);
    }
}