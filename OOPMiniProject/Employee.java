public class Employee implements java.io.Serializable, Comparable<Employee> {
    private String id;
    private String name;
    private String userName;
    private String password;
    private String authority;

    public Employee(String id, String name, String userName, String password, String authority) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.authority = authority;
    }

    public Employee(String id) { // Constructor dùng để xóa nhân viên theo ID
        this.id = id;
        this.name = "";
        this.userName = "";
        this.password = "";
        this.authority = "";
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthority() {
        return authority;
    }
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public int compareTo(Employee other) {
        return this.getId().compareTo(other.id);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return this.id.equals(employee.id); // so sánh theo ID
    }

    public int hashCode() {
        return this.getId().hashCode();
    }

    public String toString() {
        return "--------------------------\n" +
               "ID: " + id + "\n" +
               "Name: " + name + "\n" +
               "Username: " + userName + "\n"
               + "Authority: " + authority + "\n" +
               "--------------------------\n";
    }
}
