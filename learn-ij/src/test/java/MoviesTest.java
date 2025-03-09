import org.junit.jupiter.api.*;

import org.learnjava.srcForTests.Movies;
import org.mockito.Mockito;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

public class MoviesTest {

    @Test
    void givenProtectedMethod() throws NoSuchMethodException {
        //1. normal test for public method
        Movies mat = new Movies("The Matrix");
        assertEquals(mat.getPlaceHolder(), "Movie: The Matrix");

        //2. test for protected method
        Movies matrix = spy(mat);
        Method m = matrix.getClass().getDeclaredMethod("getTitle");
        m.setAccessible(true);
        //doReturn("The Matrix Reloaded").when(matrix).getTitle(); // error: getTitle() has protected access in Movies

    }
}
