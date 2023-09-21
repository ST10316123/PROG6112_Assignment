/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package progassignfinalparttwo;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


/**
 *
 * @author lab_services_student
 */
public class PatientsTest {
    
    //instance of Patients class declared
    private Patients instance;

    @Before
    // setUp() method runs before each test method which reduces for repetition in initialising instances in each test method
    public void setUp() {
        instance = new Patients();
    }

    @Test
    //Test method checks that only "M" or "F" can be chosen for male or female respectively
    public void testChooseSexValidOption() {
        //Upper casing used
        String gender1 = "M";
        String gender2 = "F";
        //Lower casing used to ensure method accepts either "M" or "F" irrespective of their casing
        String gender3 = "m";
        String gender4 = "f";
        assertTrue(instance.chooseSex(gender1));
        assertTrue(instance.chooseSex(gender2));
        assertTrue(instance.chooseSex(gender3));
        assertTrue(instance.chooseSex(gender4));
    }

    @Test
    //Test method ensures that the method deals correctly with an invalid gender option by returning false value
    public void testChooseSexInvalidOption() {
        String invalidGender1 = "X"; //random input for gender that is not male or female
        String invalidGender2 = "Y";
        assertFalse(instance.chooseSex(invalidGender1));
        assertFalse(instance.chooseSex(invalidGender2));
    }

    @Test
    //Test method checks that the age value is numeric
    public void testAgeNumericValid() {
        //String values used since isAgeNumeric() method takes in string values for testing 
        String age1 = "20"; 
        String age2 = "45";
        assertTrue(instance.isAgeNumeric(age1));
        assertTrue(instance.isAgeNumeric(age2));
    }

    @Test
    //Test method checks that if age value is invalid i.e. contains a non-numerical character
    public void testAgeNumericInvalid() {
        //String values used since isAgeNumeric() method takes in string values for testing
        String invalidAge1 = "eight";
        String invalidAge2 = "22z";
        assertFalse(instance.isAgeNumeric(invalidAge1));
        assertFalse(instance.isAgeNumeric(invalidAge2));
    }

    @Test
    //Test method checks whether CapsName capitalises names accordingly
    public void testCapsName() {
        String originalName1 = "levi ackerman";
        String expectedName1 = "Levi Ackerman";
        String originalName2 = "abdul basit deshmukh";
        String expectedName2 = "Abdul Basit Deshmukh";
        assertEquals(expectedName1, instance.CapsName(originalName1));
        assertEquals(expectedName2, instance.CapsName(originalName2));
    }

    @Test
    //Test method checks that the patient's details are saved using the savePatientDetails() method
    public void testSavePatientDetails() {
        instance.savePatientDetails("Moe Khan", "Male", 30, "0875478623"); 
        assertNotNull(instance.getPatientNames()); //checks that the patientNames ArrayList is not Empty
        //checks that details are saved accordingly and matches expected details
        assertEquals("Moe Khan", instance.getPatientNames().get(0));
        assertEquals("Male", instance.getPatientSex().get(0));
        assertEquals("0875478623", instance.getContactDetails().get(0));
    }


    @Test
    //checks that no student details are saved and displays correct message
    public void testDisplayPatientsWithNoDetails() {
        String expectedReport = "No details to show";
        String actualReport = instance.displayPatients();
        assertEquals(expectedReport, actualReport);
        assertTrue(instance.getPatientNames().isEmpty());
        assertTrue(instance.getPatientAges().isEmpty());
    }
}