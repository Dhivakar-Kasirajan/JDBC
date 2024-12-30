import java.sql.*;
public class JDBCDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//readrecord();
		//insertrec();
		//insertrecps();
		sp();

	}
	
	public static void readrecord() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/jdbcdemopro";
		String username = "root";
		String password = "!@#$ASdf1234";
		String query = "select * from employee";
		Connection con = DriverManager.getConnection(url,username,password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next())
		{
			System.out.println("Id is "+ rs.getInt(1));
			System.out.println("Name is "+ rs.getString(2));
			System.out.println("Salary is "+ rs.getInt(3));
		}
		
		
		con.close();
	}
	public static void sp() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/jdbcdemopro";
		String username = "root";
		String password = "!@#$ASdf1234";
		String query = "select * from employee";
		Connection con = DriverManager.getConnection(url,username,password);
		CallableStatement cst = con.prepareCall("{call GetAllEmployees()}");
		ResultSet rs = cst.executeQuery(query);
		
		while(rs.next())
		{
			System.out.println("Id is "+ rs.getInt(1));
			System.out.println("Name is "+ rs.getString(2));
			System.out.println("Salary is "+ rs.getInt(3));
		}
		
		
		con.close();
	}
	public static void insertrec() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/jdbcdemopro";
		String username = "root";
		String password = "!@#$ASdf1234";
		String query = "insert into employee values (4,'arctic',15000)";
		Connection con = DriverManager.getConnection(url,username,password);
		Statement st = con.createStatement();
		int rows = st.executeUpdate(query);
		
		System.out.println("no of rows affect : " + rows);
		
		
		con.close();
	}
	public static void insertrecps() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/jdbcdemopro";
		String username = "root";
		String password = "!@#$ASdf1234";
		int id = 5;
		String name = "fox";
		int salary = 50000;
		String query = "insert into employee values (?,?,?)";
		Connection con = DriverManager.getConnection(url,username,password);
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1,id);
		ps.setString(2,name);
		ps.setInt(3,salary);
		int rows =  ps.executeUpdate();
		
		System.out.println("no of rows affect : " + rows);
		
		
		con.close();
	}

}
