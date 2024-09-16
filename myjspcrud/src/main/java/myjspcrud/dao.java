package myjspcrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class dao {


	public static Connection myconnection() {
		Connection cn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost/myjspcrud","root","");

		} catch (Exception e) {
			System.out.println("connection not found");
		}
		return cn;
	}



	//data insert

		public static int datainsert(pojo p) {
			int status=0;

			Connection cn=myconnection();
			String insert="insert into girish(name,email,pass) values(?,?,?)";

			try {
			   PreparedStatement ps=cn.prepareStatement(insert);
				ps.setString(1,p.getName());
				ps.setString(2,p.getEmail());
				ps.setString(3,p.getPass());

				 status=ps.executeUpdate();

				if(status>0) {
					System.out.println("data inserted successfully");
				}
			} catch (SQLException e) {
				System.out.println("data not inserted");
			}
			return status;

		}
		//data delete

		public static int datadelete(pojo p) {
			int status=0;
			Connection cn=myconnection();
			String delete="delete from girish where id=?";

			try {
				PreparedStatement ps=cn.prepareStatement(delete);
				ps.setInt(1,p.getId());

				int a=ps.executeUpdate();

				if(a>0) {
					System.out.println("data deleted successfully");
				}
			} catch (SQLException e) {
				System.out.println("data not deleted");
			}
			return status;

		}

		//data UPDATE

		public static int dataedit(pojo p) {
			int status=0;
			Connection cn=myconnection();
			String update="update girish set name=?,email=?,pass=? where id=?";

			try {
				PreparedStatement ps=cn.prepareStatement(update);
				ps.setString(1,p.getName());
				ps.setString(2,p.getEmail());
				ps.setString(3,p.getPass());
				ps.setInt(4,p.getId());

				status=ps.executeUpdate();

				if(status>0) {
					System.out.println("data updated successfully");
				}
			} catch (SQLException e) {
				System.out.println("data not updated");
			}
			return status;

		}


		//data fetch

		public static List<pojo> getalldata(){

			List<pojo> p=new ArrayList<>();
			Connection cn=myconnection();

			String fetch="select * from girish";

			try {
				Statement ps=cn.createStatement();

				ResultSet rs=ps.executeQuery(fetch);

				while(rs.next()) {
					pojo b=new pojo();
					b.setId(rs.getInt("id"));
					b.setName(rs.getString("name"));
					b.setEmail(rs.getString("email"));
					b.setPass(rs.getString("pass"));
					p.add(b);
				}



			} catch (SQLException e) {
			System.out.println("data not fetched");
			}


			return p;

		}
		// single data fetch by id for update

        public static pojo getdatafetchbyid(int id) {

        	pojo p=null;

        	 Connection cn = myconnection();

	    	 String dfetch = "select * from girish where id=?";


	    	 try {
					PreparedStatement ps = cn.prepareStatement(dfetch);

					 ps.setInt(1, id);
					ResultSet rs= ps.executeQuery();


					while (rs.next()) {

						 p= new pojo();

						 p.setId(rs.getInt("id"));
						 p.setName(rs.getString("name"));
						 p.setEmail(rs.getString("email"));
						 p.setPass(rs.getString("pass"));


					}
				} catch (Exception e) {

					System.out.println("single data not fetch");
				}


			return p;




        }

}
