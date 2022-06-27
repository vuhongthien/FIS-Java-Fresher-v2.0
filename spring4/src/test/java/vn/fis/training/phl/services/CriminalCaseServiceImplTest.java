package vn.fis.training.phl.services;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.fis.training.phl.models.CriminalCase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CriminalCaseServiceImplTest {

    @Autowired
    CriminalCaseServiceImpl criminalCaseService;

    @Test
    @Order(1)
    void getAll() {
        List<CriminalCase> list = criminalCaseService.getAll();
        list.stream().forEach(criminalCase -> System.out.println(criminalCase));
        //assertEquals(6,list.size());
    }

    @Test
    @Order(2)
    void findById() {
        CriminalCase findCri = criminalCaseService.findById(2L);
        System.out.println(findCri);
    }

    @Test
    @Order(3)
    void create() {
        CriminalCase createCri = new CriminalCase();
        createCri.setId(7L);
        createCri.setVersion(1);
        createCri.setNumber("number7");
        createCri.setShortDescription("create7");
        CriminalCase resultCri = criminalCaseService.create(createCri);
        //System.out.println(resultCri);
        assertEquals("create7",resultCri.getShortDescription());
    }

    @Test
    @Order(4)
    void update_ExistId() {
        CriminalCase updateCri = new CriminalCase();
        updateCri.setId(7L);
        updateCri.setShortDescription("short has changed");
        CriminalCase resultCri = criminalCaseService.update(updateCri);
        //System.out.println(resultCri);
        assertEquals("short has changed",resultCri.getShortDescription());
    }

    @Test
    @Order(5)
    void update_NotExistId() {
        CriminalCase updateCri = new CriminalCase();
        updateCri.setId(1117L);
        updateCri.setShortDescription("short has changed");
        CriminalCase resultCri = criminalCaseService.update(updateCri);
        //System.out.println(resultCri);
        assertNull(resultCri);
    }

    @Test
    @Order(6)
    void delete_ExistId() {
        Long idDelete = 7L;
        CriminalCase resultCri = criminalCaseService.delete(idDelete);
        assertNotNull(resultCri);
    }

    @Test
    @Order(7)
    void delete_NotExistId() {
        Long idDelete = 117L;
        CriminalCase resultCri = criminalCaseService.delete(idDelete);
        assertNull(resultCri);
    }
}