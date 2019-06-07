package model.szerelesek;

import controller.db.DBConnect;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class SzereloTest {

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
    void setNev() {
        Szerelo szerelo = new Szerelo("Teszt Lajos", 1);
        szerelo.setNev("Teszt János");
        assertEquals("Teszt János", szerelo.getNev());
    }

    @Test
    void testGetSzerelok() {
        assertNotNull(DBConnect.getSzerelok(), "Nem található a Szerelo tábla");
    }

    @Test
    void testGetMuhelyNev() {
        assertEquals("Madád szervíz", DBConnect.getMuhelyNev(1));
    }

}