
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.diginamic.immobilier.entites.Chambre;
import fr.diginamic.immobilier.entites.Cuisine;
import fr.diginamic.immobilier.entites.Maison;
import fr.diginamic.immobilier.entites.SalleDeBain;

public class MaisonTest {

    private Maison maison;

    @BeforeEach
    public void setUp() {
        maison = new Maison();
    }

    @Test
    public void testAjouterPiece_CasNominal() {
        Chambre chambre = new Chambre(1, 20);
        maison.ajouterPiece(chambre);
        assertEquals(1, maison.nbPieces());
        assertEquals(chambre, maison.getPieces()[0]);
    }

    @Test
    public void testAjouterPiece_CasNull() {
        try {
            maison.ajouterPiece(null);
            fail("Expected IllegalArgumentException for null rhs");
        } catch (IllegalArgumentException e) {
            assertEquals("La pièce est invalide : elle ne doit pas être nulle, et doit avoir une superficie positive", e.getMessage());
        }
    }

    @Test
    public void testNbPieces() {
        assertEquals(0, maison.nbPieces());
        maison.ajouterPiece(new Cuisine(2, 40));
        maison.ajouterPiece(new Chambre(1, 50));
        assertEquals(2, maison.nbPieces());
    }

    @Test
    public void testSuperficieEtage_CasNominal() {
        maison.ajouterPiece(new Chambre(1, 50));
        maison.ajouterPiece(new SalleDeBain(1, 20));
        maison.ajouterPiece(new Cuisine(0, 40));

        assertEquals(40, maison.superficieEtage(0), 0.001);
        assertEquals(70, maison.superficieEtage(1), 0.001);
    }

    @Test
    public void testSuperficieEtage_EtageSansPiece() {
        maison.ajouterPiece(new Chambre(1, 15));
        assertEquals(0, maison.superficieEtage(2), 0.001);
    }

    @Test
    public void testSuperficieTypePiece_CasNominal() {
        maison.ajouterPiece(new Chambre(0, 15));
        maison.ajouterPiece(new Chambre(1, 10));
        maison.ajouterPiece(new Cuisine(0, 20));

        assertEquals(25, maison.superficieTypePiece("Chambre"), 0.001);
        assertEquals(20, maison.superficieTypePiece("Cuisine"), 0.001);
    }

    @Test
    public void testSuperficieTypePiece_TypeInexistant() {
        maison.ajouterPiece(new Chambre(0, 20));
        assertEquals(0, maison.superficieTypePiece("Salon"), 0.001);
    }

    @Test
    public void testCalculerSurface() {
        maison.ajouterPiece(new Chambre(0, 15));
        maison.ajouterPiece(new Cuisine(0, 20));
        maison.ajouterPiece(new SalleDeBain(1, 5));

        assertEquals(40, maison.calculerSurface(), 0.001);
    }
}
