import org.junit.jupiter.api.*;

import  org.junit.jupiter.api.Assertions;

public class AnnotationsTest {
    @Disabled("my disabled test")
    @DisplayName("this is my test")
    @Test
    void one(){
        Assertions.assertTrue(true);
    }
}
