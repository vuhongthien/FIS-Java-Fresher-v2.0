package com.pluralsight.persistence.module06.demo02;

import com.pluralsight.persistence.module06.Musician;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static com.pluralsight.persistence.module06.Util.date;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AuthorServiceTest {

  // ======================================
  // =             Attributes             =
  // ======================================

  private static EntityManagerFactory emf;
  private static EntityManager em;
  private static EntityTransaction tx;

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeAll
  public void initEntityManager() {
    emf = Persistence.createEntityManagerFactory("module06-persistence-unit");
    em = emf.createEntityManager();
    tx = em.getTransaction();
  }

  @AfterAll
  public void closeEntityManager() {
    if (em != null) em.close();
    if (emf != null) emf.close();
  }

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldManageMusician() {

    Musician musician = new Musician("John", "Smith", date("01/01/1975"));
    MusicianService service = new MusicianService(em);

    // Creates and persists an author
    tx.begin();
    Long id = service.createMusician(musician);
    tx.commit();
    assertNotNull(id);

    // Finds the book by primary key
    musician = service.findMusician(id);
    assertTrue(musician.getAge() >= 44);
  }

  @Test//(expected = IllegalArgumentException.class)
  public void shouldCheckInvalidMusicianNull() {

    Musician musician = new Musician(null, null, null);
    MusicianService service = new MusicianService(em);

    // Creates and persists an author
    tx.begin();
    service.createMusician(musician);
    tx.commit();
  }

  @Test//(expected = IllegalArgumentException.class)
  public void shouldCheckInvalidMusicianEmpty() {

    Musician musician = new Musician("", "", null);
    MusicianService service = new MusicianService(em);

    // Creates and persists an author
    tx.begin();
    service.createMusician(musician);
    tx.commit();
  }
}