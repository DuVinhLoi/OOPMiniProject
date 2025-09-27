import java.io.*;
public class DangNhapSession {
    private static final String FILE_NAME = "DangDangNhap.data";

    // Lưu nhân viên đang đăng nhập
    public static void save(Employee e) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Đọc nhân viên đang đăng nhập (nếu có)
    public static Employee load() {
    File f = new File(FILE_NAME);
    if (!f.exists() || f.length() == 0) {
        return null; // chưa có ai đăng nhập
    }
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
        return (Employee) ois.readObject();
    } catch (Exception ex) {
        return null;
    }
}


   public static void clear() {
    try (FileOutputStream fos = new FileOutputStream(FILE_NAME)) {
        // không ghi gì, chỉ mở rồi đóng lại
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

}
