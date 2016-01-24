public class Person implements java.io.Serializable {
  private static final long serialVersionUID = 85731937678276152L;
  private final String name;
  private int id;

  public Person(String name, int id) {
    this.name = name;
    this.id = id;
  }

  public String toString() {
    return name + ", " + id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
  
