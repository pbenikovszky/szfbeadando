package model.autok;

import controller.db.DBConnect;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class TulajAutokTest {

    private EntityManager em;
    private static EntityManagerFactory emf;

    @BeforeAll
    public static void init(){
        emf = Persistence.createEntityManagerFactory("autoszereloDBPU");
    }

    @BeforeEach
    void setUp() {
        em = emf.createEntityManager();
    }

    @AfterEach
    void tearDown() {
        em.close();
    }

    @AfterAll
    public static void destroy(){
        emf.close();
    }

    @Test
    void getNev() {

        Tulaj tulaj = new Tulaj("Tulaj János", "test");
        assertEquals("Tulaj János", tulaj.getNev());

    }

    @Test
    void setNev() {
        Tulaj tulaj = new Tulaj("Tulaj János", "test");
        tulaj.setNev("Tulaj Péter");
        assertEquals("Tulaj Péter", tulaj.getNev());
    }

    @Test
    void testGetTulajdonosok() {
        assertNotNull(DBConnect.getTulajdonosok(), "Nem található a Tulaj tábla");
    }

    @Test
    void testGetTulajdonosNev() {
        assertEquals("Szabó Géza", DBConnect.getTulajdonosNev(1));
    }

//    @Test
//    void testGetTulajdonosok() {
//        assertNotNull(DBConnect.getTulajdonosok(), "Nem található a Tulaj tábla");
//    }

}