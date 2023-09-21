/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package progassignfinalparttwo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lab_services_student
 */
public class AppointmentsTest {
    
    public AppointmentsTest() {
    }
    
    private Appointments instance;
    
    @Before
    public void setUp() {
        instance = new Appointments();
    }
    

    @Test
    //Tests that the default Booking times are filled and available for the user
    public void testDefaultDailyTimes() {
        instance.defaultDailyTimes();
        assertFalse(instance.getBookingTimes().isEmpty());
    }

    @Test
    //Tests that the user is displayed with the correct booking times as saved
    public void testBookingTimesAvailableWithAvailableTimes() {
        instance.defaultDailyTimes(); //saves the default times for available bookings
        String expectedMessage = "These are the available times:\n"
                + "\n1) 8:00 - 9:00"
                + "\n2) 9:00 - 10:00"
                + "\n3) 10:00 - 11:00"
                + "\n4) 11:00 - 12:00"
                + "\n5) 12:00 - 13:00";
        String actualMessage = instance.bookingTimesAvailable();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    //Tests that no bookings available
    public void testBookingTimesAvailableWithNoAvailableTimes() {
        instance.defaultDailyTimes(); //default Times are added
        //All available times are booked 
        instance.bookedTime(5);
        instance.bookedTime(4);
        instance.bookedTime(3);
        instance.bookedTime(2);
        instance.bookedTime(1);
        String expectedMessage = "No available times for booking";
        String actualMessage = instance.bookingTimesAvailable();
        assertEquals(expectedMessage,actualMessage);
    }

    @Test
    //Tests that correct time is booked for
    public void testBookedTime() {
        //default available times added first
        instance.defaultDailyTimes();
        //Second time session is booked which contains 9
        instance.bookedTime(2);
        assertFalse(instance.getBookingTimes().contains(9)); //checks avalailable booking times is updated
        assertTrue(instance.getReservedTimes().contains(9));
    }
    
    
}
