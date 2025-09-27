import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
public class QLDanhSachLapTop {
    public ArrayList<LapTop> danhSachLapTop;

    public QLDanhSachLapTop() {
        this.danhSachLapTop = new ArrayList<>();
    }

    public QLDanhSachLapTop(ArrayList<LapTop> danhSachLapTop) {
        this.danhSachLapTop = danhSachLapTop;
    }

    public void themLapTop(LapTop laptop) {
        danhSachLapTop.add(laptop);
    }

    public void hienThiDanhSach() {
        System.out.println("Danh sách Laptop:");
        for (LapTop laptop : danhSachLapTop) {
            System.out.println(laptop);
        }
    }
    public void setDanhSach(ArrayList<LapTop> ds) {
    this.danhSachLapTop = ds;
    }
    public ArrayList<LapTop> getDanhSachLapTop() {
    return danhSachLapTop;
    }

    public boolean xoaLapTop(LapTop lapTop) {
        return this.danhSachLapTop.remove(lapTop);  //remove() sẽ so sánh dựa trên equals(). Phải override equals() trong lớp LapTop
    }

    public void xoaHetLapTop() {
        this.danhSachLapTop.clear();
    }

    public void suaLapTop(String id, LapTop lapTopMoi) {
        for (int i = 0; i < danhSachLapTop.size(); i++) {
            if (danhSachLapTop.get(i).getId().equals(id)) {
                danhSachLapTop.set(i, lapTopMoi); // cập nhật toàn bộ bằng laptop mới
                System.out.println("Đã cập nhật Laptop thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy Laptop với ID này!");
    }

    public void ghiDuLieuXuongFile(File file){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(danhSachLapTop);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ghi dữ liệu xuống file thất bại!");
        }
    }
}
