// QLDSInvoice.java
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class QLDSInvoice {
    private ArrayList<Invoice> danhSachInvoice;

    public QLDSInvoice() {
        this.danhSachInvoice = new ArrayList<>();
    }

    public void themInvoice(Invoice invoice) {
        danhSachInvoice.add(invoice);
    }

    public void hienThiDanhSach() {
        System.out.println("Danh sách Hóa đơn:");
        for (Invoice invoice : danhSachInvoice) {
            System.out.println(invoice);
        }
    }

    public void ghiDuLieuXuongFile(File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(danhSachInvoice);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ghi dữ liệu hóa đơn xuống file thất bại!");
        }
    }

    public void docDuLieuTuFile(File file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            danhSachInvoice = (ArrayList<Invoice>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Đọc dữ liệu hóa đơn từ file thất bại!");
        }
    }

    public void xoaHetInvoice() {
        danhSachInvoice.clear();
        System.out.println("Đã xóa hết hóa đơn trong danh sách.");
    }

    public ArrayList<Invoice> getDanhSach() {
        return danhSachInvoice;
    }
}