// AuthService.java
public class AuthService {
    private QLDSNhanVien qlds;

    public AuthService(QLDSNhanVien qlds) {
        this.qlds = qlds;
    }

    public Employee checkLogin(String username, String password) {
        for (Employee e : qlds.getDanhSach()) {
            if (e.getUserName().equals(username) && e.getPassword().equals(password)) {
                return e;
            }
        }
        return null;
    }

    public boolean hasAuthorityManager(Employee e, String requiredAuthority) {
        if (e == null) return false; // chưa đăng nhập
        return e.getAuthority().equalsIgnoreCase(requiredAuthority);
    }
}
