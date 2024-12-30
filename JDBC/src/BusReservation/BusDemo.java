package BusReservation;
import java.util.Scanner;

public class BusDemo {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		try{
			BusDAO busdao = new BusDAO();
		busdao.displayBusInfo();
		int userOpt = 1;
		Scanner sc = new Scanner(System.in);
		
		
		
		while(userOpt == 1)
		{
			System.out.println("Enter 1 to Book and 2 to exit");
			userOpt = sc.nextInt();
			
			if(userOpt == 1 )
			{
				Booking booking = new Booking();
				if(booking.isAvailable())
				{
					BookingDAO bookingdao = new BookingDAO();
					bookingdao.addBooking(booking);
					System.out.println("Your booking is confirmed");
				}
				else {
					System.out.println("Sorry. Bus is full. Try another bus or date.");
				}
			}
		}
		sc.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
