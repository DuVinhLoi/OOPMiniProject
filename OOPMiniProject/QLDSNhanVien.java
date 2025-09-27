import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
public class QLDSNhanVien implements Serializable {
    private ArrayList<Employee> danhSachNhanVien;

    public QLDSNhanVien() {
        this.danhSachNhanVien = new ArrayList<>();
    }

    public QLDSNhanVien(ArrayList<Employee> danhSachNhanVien) {
        this.danhSachNhanVien = danhSachNhanVien;
    }
    public ArrayList<Employee> getDanhSach() {
    return danhSachNhanVien;
    }
    public void setDanhSach(ArrayList<Employee> danhSachNhanVien) {
        this.danhSachNhanVien = danhSachNhanVien;
    }

    public void themNhanVien(Employee nv) {
        danhSachNhanVien.add(nv);
    }

    public void hienThiDanhSach() {
        System.out.println("Danh sách Nhân Viên:");
        for (Employee nv : danhSachNhanVien) {
            System.out.println(nv);
        }
    }

    public boolean xoaNhanVien(Employee nv) {
        return this.danhSachNhanVien.remove(nv);  //remove() sẽ so sánh dựa trên equals(). Phải override equals() trong lớp Employee
    }

    public void xoaHetNhanVien() {
        danhSachNhanVien.clear();
        System.out.println("Đã xóa hết Nhân Viên trong danh sách.");
    }

    public void suaNhanVien(String id, Employee nvMoi) {
        for (int i = 0; i < danhSachNhanVien.size(); i++) {
            if (danhSachNhanVien.get(i).getId().equals(id)) {
                danhSachNhanVien.set(i, nvMoi); // cập nhật toàn bộ bằng nhân viên mới
                System.out.println("Đã cập nhật Nhân Viên thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy Nhân Viên với ID này!");
    }

    public void ghiDuLieuXuongFile(File file){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(danhSachNhanVien);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ghi dữ liệu xuống file thất bại!");
        }
    }

}
