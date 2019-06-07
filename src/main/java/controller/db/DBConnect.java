package controller.db;


import javafx.collections.ObservableList;
import model.autok.Auto;
import model.autok.AutoTablasor;
import model.autok.Tulaj;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.szerelesek.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;


public class DBConnect implements AutoCloseable {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("autoszereloDBPU");
    public static EntityManager em;

    @Override
    public void close() throws Exception {
        if(emf!=null)
            emf.close();
    }

    public static List<AutoTablasor> getAutok() {
        em = emf.createEntityManager();
        TypedQuery<Auto> query = em.createQuery("SELECT a FROM Auto a", Auto.class);
        List<Auto> autoList = query.getResultList();
        List<AutoTablasor> result = new ArrayList<>();
        for (Auto auto: autoList) {
            result.add(new AutoTablasor(auto, getTulajdonosNev(auto.getTulaj_id())));
        }
        return result;
    }

    public static List<Tulaj> getTulajdonosok() {
        em = emf.createEntityManager();
        TypedQuery<Tulaj> query = em.createQuery("SELECT t FROM Tulaj t", Tulaj.class);
        List<Tulaj> result = query.getResultList();
        return result;
    }

    public static List<Muhely> getMuhelyek() {
        em = emf.createEntityManager();
        TypedQuery<Muhely> query = em.createQuery("SELECT m FROM Muhely m", Muhely.class);
        List<Muhely> result = query.getResultList();
        return result;
    }

    public static List<SzereloTablasor> getSzerelok() {
        em = emf.createEntityManager();
        TypedQuery<Szerelo> query = em.createQuery("SELECT sz FROM Szerelo sz", Szerelo.class);
        List<Szerelo> szereloList = query.getResultList();
        List<SzereloTablasor> result = new ArrayList<>();
        for (Szerelo szerelo: szereloList) {
            result.add(new SzereloTablasor(szerelo, getMuhelyNev(szerelo.getMuhely_id())));
        }
        return result;
    }

    public static List<SzerelesTablasor> getSzerelesek() {
        em = emf.createEntityManager();
        TypedQuery<Szereles> query = em.createQuery("SELECT sz FROM Szereles sz", Szereles.class);
        List<Szereles> szerelesList = query.getResultList();
        List<SzerelesTablasor> result = new ArrayList<>();
        for (Szereles szereles : szerelesList) {
            result.add(new SzerelesTablasor(
                    szereles.getId(),
                    getRendszam(szereles.getAuto_id()),
                    getMuhelyNev(szereles.getMuhely_id()),
                    getSzereloNev(szereles.getSzerelo_id()),
                    szereles.getStatusz(),
                    szereles.getAr()));
        }
        return result;
    }

    public static boolean createTulajdonos(Tulaj ujTulaj) {
        try {

            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(ujTulaj);
            em.getTransaction().commit();
            return true;

        } catch (HibernateException e) {
            return false;
        } finally {
            em.close();
        }
    }

    public static boolean createAuto(Auto ujAuto) {
        try {

            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(ujAuto);
            em.getTransaction().commit();
            return true;

        } catch (HibernateException e) {
            return false;
        } finally {
            em.close();
        }
    }

    public static String getRendszam(Integer id) {
        em = emf.createEntityManager();
        Query query = em.createQuery("SELECT a FROM Auto a WHERE a.id = :aid");
        query.setParameter("aid", id);
        List<Auto> result = query.getResultList();
        return result.get(0).getRendszam();
    }

    public static String getTulajdonosNev(Integer id) {
        em = emf.createEntityManager();
        Query query = em.createQuery("SELECT t FROM Tulaj t WHERE t.id = :tid");
        query.setParameter("tid", id);
        List<Tulaj> result = query.getResultList();
        return result.get(0).getNev();
    }

    public static String getMuhelyNev(Integer id) {
        em = emf.createEntityManager();
        Query query = em.createQuery("SELECT m FROM Muhely m WHERE m.id = :mid");
        query.setParameter("mid", id);
        List<Muhely> result = query.getResultList();
        return result.get(0).getNev();
    }

    public static String getSzereloNev(Integer id) {
        em = emf.createEntityManager();
        Query query = em.createQuery("SELECT sz FROM Szerelo sz WHERE sz.id = :szid");
        query.setParameter("szid", id);
        List<Szerelo> result = query.getResultList();
        return result.get(0).getNev();
    }

    public static Map<Integer, String> getTulajdonosMap() {
        List<Tulaj> tulajok = getTulajdonosok();
        Map<Integer, String> result = tulajok.stream().collect(Collectors.toMap(
                tulaj -> tulaj.getId(),
                tulaj2 -> tulaj2.getNev()
        ));
        return result;
    }

    public static List<Auto> getAutoFromTulajdonos(Integer tid) {
        em = emf.createEntityManager();
        Query query = em.createQuery("SELECT a FROM Auto a WHERE a.tulaj_id = :tid");
        query.setParameter("tid", tid);
        List<Auto> result = query.getResultList();
        return result;
    }

    public static Integer getTulajID(String name) {
        em = emf.createEntityManager();
        Query query = em.createQuery("SELECT t FROM Tulaj t WHERE t.nev = :tnev");
        query.setParameter("tnev", name);
        List<Tulaj> result = query.getResultList();
        return result.get(0).getId();
    }


}
