
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import fr.diginamic.utils.StringUtils;

public class StringUtilsTest {

    @Test
    public void testLevenshteinDistance_CasNominal() {
        assertEquals(0, StringUtils.levenshteinDistance("chat", "chat"));
        assertEquals(1, StringUtils.levenshteinDistance("chat", "chats"));
        assertEquals(2, StringUtils.levenshteinDistance("chiens", "chine"));
        assertEquals(2, StringUtils.levenshteinDistance("distance", "instance"));
    }

    @Test
    public void testLevenshteinDistance_CasLimites() {
        // Cas de chaînes vides
        assertEquals(5, StringUtils.levenshteinDistance("", "hello"));
        assertEquals(5, StringUtils.levenshteinDistance("hello", ""));
        assertEquals(0, StringUtils.levenshteinDistance("", ""));
        try {
            StringUtils.levenshteinDistance(null, "test");
            fail("Expected IllegalArgumentException for null lhs");
        } catch (IllegalArgumentException e) {
            assertEquals("Les chaînes de caractères ne doivent pas être nulles.", e.getMessage());
        }

        try {
            StringUtils.levenshteinDistance("test", null);
            fail("Expected IllegalArgumentException for null rhs");
        } catch (IllegalArgumentException e) {
            assertEquals("Les chaînes de caractères ne doivent pas être nulles.", e.getMessage());
        }

        try {
            StringUtils.levenshteinDistance(null, null);
            fail("Expected IllegalArgumentException for null lhs and rhs");
        } catch (IllegalArgumentException e) {
            assertEquals("Les chaînes de caractères ne doivent pas être nulles.", e.getMessage());
        }
    }
}
