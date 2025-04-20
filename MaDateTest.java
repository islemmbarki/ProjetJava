import org.junit.Test;
import static org.junit.Assert.*;

public class MaDateTest {
    @Test
    public void testDateValide() {
        MaDate date = new MaDate(15, 6, 2023);  // Doit fonctionner
        assertEquals(15, date.getJJ());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testJourInvalide() {
        new MaDate(32, 6, 2023);  // Doit lancer une exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMoisInvalide() {
        new MaDate(15, 13, 2023);  // Doit lancer une exception
    }
}