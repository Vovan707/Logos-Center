import java.sql.*;
import java.sql.PreparedStatement;
import java.util.*;

import com.mysql.jdbc.*;

public class Menu {
  public static final String URL = "jdbc:mysql://localhost/person";
  public static final String USER = "root";
  public static final String PASSWORD = "root";
  public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  private static java.sql.Connection conn = null;
  public static PreparedStatement ps = null;
  
  public static void showMenu(){
    System.out.println("1 - Add Person");
    System.out.println("2 - Delete Person");
    System.out.println("3 - Show all Person");
    System.out.println("0 - Exit");
  }
  
  public static void showPerson(){
    List<Person> list = new ArrayList<Person>();
    ResultSet res;
    try {
      res = ps.executeQuery("select * from person");
    
    while(res.next()) {
      list.add(new Person(res.getInt(1),res.getString(2),res.getString(3), res.getInt(4)));
    }
    System.out.println("¹ |Persons Name|Age");
    for (Person person : list) {
      System.out.println(person);
    }
    System.out.println("\n");
    } catch (SQLException e) {
      e.printStackTrace();
    }finally{
    try {
      ps.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    }
  }
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int menu;
    boolean status = true;
    try {     
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(URL, USER, PASSWORD);
      ps = conn.prepareStatement("create table if not exists person (`id` int not null auto_increment, `firstName` varchar(50), `lastName` varchar(50), age int, primary key (id))");
      ps.execute();
      while(status){
        showMenu();
        menu = scanner.nextInt();
        if(menu == 1){
          System.out.println("Enter First Name please");
          String firstName = scanner.next();
          System.out.println("Enter Second Name please");
          String secondName = scanner.next();
          System.out.println("Enter Age");
          int age = scanner.nextInt();
          ps = conn.prepareStatement("insert into person (firstName,lastName,age) values(?,?,?)");
          ps.setString(1, firstName);
          ps.setString(2, secondName);
          ps.setInt(3, age);
          ps.execute();
        }
        else if(menu == 2){
          showPerson();
          System.out.println("Select id for delete: ");
          int id = scanner.nextInt();
          ps = conn.prepareStatement("delete from person where id = ?");
          ps.setInt(1, id);
          ps.execute();
        }
        else if(menu == 3){
          showPerson();
        }
        else if(menu == 0){
          System.out.println("Good bye");
          status = false;
        }
        else{
          System.out.println("You Enter wrong number!");
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }catch (InputMismatchException e) {
      System.err.println("You select symbol\nGood bye!");
    } 
  }
}
