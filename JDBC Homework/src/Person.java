public class Person {
  private int id;
  private String firstName;
  private String secondName;
  private int age;
  
  public Person(int id, String firstName, String secondName, int age) {
    this.id = id;
    this.firstName = firstName;
    this.secondName = secondName;
    this.age = age;
  }

  @Override
  public String toString() {
    return id + " " + firstName + " "
        + secondName + " " + age;
  }
  
}

