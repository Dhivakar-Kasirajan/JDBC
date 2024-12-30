package BusReservation;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Booking {

	String passengerName;
	int busNo;
	Date date;
	
	Booking(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name of Passenger: ");
		passengerName= sc.next();
		System.out.println("Enter busNo: ");
		busNo = sc.nextInt();
		System.out.println("Enter date: ");
		String dateInput = sc.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			date = dateFormat.parse(dateInput);
		} catch (ParseException e) {
			// TODO Auto-generated catch bloc k
			e.printStackTrace();
		}
	}
	
	public boolean isAvailable() throws SQLException
	{
		BusDAO busdao = new BusDAO();
		BookingDAO bookingdao = new BookingDAO();
		int capacity = busdao.getCapacity(busNo);
		int booked = bookingdao.getBookedCount(busNo,date); 
		
		
		return booked<capacity;
	}
}
