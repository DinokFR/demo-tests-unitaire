
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

import fr.diginamic.enumerations.Saison;

public class SaisonTest {

    @Test
    public void testValueOfLibelle_CasNominal() {
        Saison printemps = Saison.valueOfLibelle("Printemps");
        assertEquals(Saison.PRINTEMPS, printemps);

        Saison ete = Saison.valueOfLibelle("Été");
        assertEquals(Saison.ETE, ete);

        Saison automne = Saison.valueOfLibelle("Automne");
        assertEquals(Saison.AUTOMNE, automne);

        Saison hiver = Saison.valueOfLibelle("Hiver");
        assertEquals(Saison.HIVER, hiver);
    }

    @Test
    public void testValueOfLibelle_CasLimites() {
        // Cas de libellé incorrect ou inconnu
        assertNull(Saison.valueOfLibelle("printemps"));
        assertNull(Saison.valueOfLibelle("été"));
        assertNull(Saison.valueOfLibelle("automne"));
        assertNull(Saison.valueOfLibelle("hiver"));
        assertNull(Saison.valueOfLibelle("InvalidSaison"));
    }
}
