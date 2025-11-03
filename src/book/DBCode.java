package book;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCode implements Serializable {
	private static final long SerialVersionUID=1L;
	private String url="jdbc:mysql://localhost:3308/saamp";
	private String user="root";
	private String pass="rajesh";
	private Connection con;
	
	public DBCode() throws SQLException {
		con=DriverManager.getConnection(url,user,pass);
	}
	public int register(String cn,String un,String pass)throws SQLException {
		String q="insert into book(cname,username,password)values (?,?,?)";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setString(1, cn);
		pst.setString(2, un);
		pst.setString(3, pass);
		int res=pst.executeUpdate();
		return res;
		
	}
	public boolean login(String n,String pass)throws SQLException {
		boolean res=false;
		String q="Select* from book  where username=? and password=?";
		PreparedStatement pst=con.prepareStatement(q);
		pst.setString(1,n);
		pst.setString(2,pass);
		ResultSet rs=pst.executeQuery();
		while(rs.next()) {
			res=true;
		}
		return res;
	}
	public int Add(String T,String cname,String A,long C,String pd,String p,String I)throws SQLException{
		String d="insert into Book(Title,cname,Author,CallNumber,PublishDate,Publisher,ISBNNumber)values(?,?,?,?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(d);
		pst.setString(1,T);
		pst.setString(2, cname);
		pst.setString(3, A);
		pst.setLong(4, C);
		pst.setString(5, pd);
		pst.setString(6, p);
		pst.setString(7, I);
//		pst.setString(8, username);
//		pst.setString(9, password);
//		pst.setLong(10, Cid);
		int r=pst.executeUpdate();
		return r;
	}
	public void view()throws SQLException{
		String d="select *from book";
		PreparedStatement pst=con.prepareStatement(d);
		ResultSet rs=pst.executeQuery();
		while(rs.next()) {
			String title=rs.getString(1);
			String cn=rs.getString(2);
			String auth=rs.getString(3);
			Long cnum=rs.getLong(4);
			String pd=rs.getString(5);
			String pub=rs.getString(6);
			String isnum=rs.getString(7);
			String uname=rs.getString(8);
			String pass=rs.getString(9);
			String id=rs.getString(10);
			
			System.out.println(title+"\t"+cn+"\t"+auth+"\t"+cnum+"\t"+pd+"\t"+pub+"\t"+isnum+"\t"+uname+"\t"+pass+"\t"+id);
		}
		
	}
	public void view(String T)throws SQLException{
		String d="select Author,PublishDate,Publisher from Book where Title=?";
		PreparedStatement pst=con.prepareStatement(d);
		pst.setString(1,T);
		ResultSet rs=pst.executeQuery();
	    int k=0;
	    while(rs.next()) {
	    	k++;
	    	System.out.println(T+"DataList");
	    	System.out.println("Author:"+rs.getString(1));
	    	System.out.println("PublishDate:"+rs.getString(2));
	    	System.out.println("Publisher:"+rs.getString(3));
	    	
	    }
	    if(k==0) {
	    	System.out.println("Data Not Found");
	    }
		
	}
	public void count()throws SQLException{
		String d="select count(*) from book";
		PreparedStatement pst=con.prepareStatement(d);
		ResultSet rs=pst.executeQuery();
		int k=0;
		while(rs.next()) {
			System.out.println("No Of Books:"+rs.getInt(1));
		}
	}
	public int update(String T,String A) throws SQLException{
		String d="update book set Author=? where Title=?";
		PreparedStatement pst=con.prepareStatement(d);
		pst.setString(1,A);
		pst.setString(2,T);
		int r=pst.executeUpdate();
		return r;
	}
	public int delete(String T)throws SQLException{
		String d="delete from book where Title=?";
		PreparedStatement pst=con.prepareStatement(d);
		pst.setString(1, T);
		int r=pst.executeUpdate();
		return r;
	}
	


}
