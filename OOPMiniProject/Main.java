//User: admin0 pass:123 đã có sẵn trong file
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
public class Main {
    public static void main(String[] args) {
        QLDanhSachLapTop qlDanhSachLapTop = new QLDanhSachLapTop();
        QLDSNhanVien qlDSNhanVien = new QLDSNhanVien();
        AuthService auth = new AuthService(qlDSNhanVien);
        QLDSInvoice qlDSInvoice = new QLDSInvoice();
        
        //Load dữ liệu laptop
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DSLapTop.data"))) {
            ArrayList<LapTop> dsLapTop = (ArrayList<LapTop>) ois.readObject();
            qlDanhSachLapTop.setDanhSach(dsLapTop);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Load dữ liệu nhân viên
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("NhanVien.data"))) {
            ArrayList<Employee> dsNhanVien = (ArrayList<Employee>) ois.readObject();
            qlDSNhanVien.setDanhSach(dsNhanVien);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Load dữ liệu hóa đơn
        File invoiceFile = new File("Invoice.data");
        if (invoiceFile.exists()) {
            qlDSInvoice.docDuLieuTuFile(invoiceFile);
        }

        Scanner sc = new Scanner(System.in);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Username: ");
        String user = scanner.nextLine();
        System.out.print("Password: ");
        String pass = scanner.nextLine();
        Employee e = auth.checkLogin(user, pass);
        DangNhapSession.save(e); // Lưu lại trạng thái đăng nhập

        int luaChon = 0;

        do {
            System.out.println("-----------------MENU----------------");
            if (auth.hasAuthorityManager(e, "M")) {
            System.out.println("1. Thêm Laptop");
            System.out.println("2. Hiển thị danh sách Laptop");
            System.out.println("3. Xóa Laptop");
            System.out.println("4. Sửa Laptop");
            System.out.println("5. Ghi dữ liệu xuống file(Chương trình không tự động lưu thay đổi mỗi lần thêm/sửa/xóa Laptop)");
            System.out.println("6. Xóa hết Laptop");
            System.out.println("7. Thêm nhân viên");
            System.out.println("8. Hiển thị danh sách nhân viên");
            System.out.println("9. Ghi danh sách nhân viên xuống file(Chương trình không tự động lưu thay đổi mỗi lần thêm/sửa/xóa nhân viên)");
            System.out.println("10. Xóa hết nhân viên");
            System.out.println("11. Sửa nhân viên");
            System.out.println("12. Xóa nhân viên");
            System.out.println("13. Xuất hóa đơn (Tự động cập nhật lên file hóa đơn và file laptop)");
            System.out.println("14. Xem các hóa đơn đã xuất");
            System.out.println("15. Xóa hết hóa đơn");
            System.out.println("0. Thoát đăng nhập");
            }else{
            System.out.println("2. Hiển thị danh sách Laptop");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");}
            luaChon = sc.nextInt();
            switch (luaChon) {
                case 0:
                    System.out.println("Thoát chương trình.");
                    DangNhapSession.clear(); // Xóa trạng thái đăng nhập
                    break;
                case 1:
                    if (!auth.hasAuthorityManager(e, "M")) {
                    System.out.println("Bạn không có quyền");
                    break;
                    }
                    sc.nextLine();
                    System.out.print("Nhập ID: ");
                    String id = sc.nextLine();
                    System.out.print("Nhập Tên: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập Hãng: ");
                    String brand = sc.nextLine();
                    System.out.print("Nhập Giá: ");
                    double price = sc.nextDouble();
                    System.out.print("Nhập Số lượng: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nhập CPU: ");
                    String cpu = sc.nextLine();
                    System.out.print("Nhập RAM: ");
                    int ram = sc.nextInt();
                    System.out.print("Nhập Storage: ");
                    int storage = sc.nextInt();
                    sc.nextLine(); //Để xóa int đi
                    System.out.print("Nhập GPU: ");
                    String gpu = sc.nextLine();
                    LapTop lapTop = new LapTop(id, name, brand, price, quantity, cpu, ram, storage, gpu);
                    qlDanhSachLapTop.themLapTop(lapTop);
                    sc.nextLine(); // Consume newline
                    break;
                case 2:
                    qlDanhSachLapTop.hienThiDanhSach();
                    break;
                case 3:
                if (!auth.hasAuthorityManager(e, "M")) {
                    System.out.println("Bạn không có quyền");
                    break;
                    }
                    sc.nextLine();
                    System.out.print("Nhập ID Laptop cần xóa: ");
                    String idXoa = sc.nextLine();
                    LapTop lapTopXoa = new LapTop(idXoa);
                    qlDanhSachLapTop.xoaLapTop(lapTopXoa);
                    break;
                case 4:
                if (!auth.hasAuthorityManager(e, "M")) {
                    System.out.println("Bạn không có quyền");
                    break;
                    }
                sc.nextLine();
                System.out.print("Nhập ID Laptop cần sửa: ");
                String idSua = sc.nextLine();

                System.out.print("Nhập Tên mới: ");
                String nameSua = sc.nextLine();
                System.out.print("Nhập Hãng mới: ");
                String brandSua = sc.nextLine();
                System.out.print("Nhập Giá mới: ");
                double priceSua = sc.nextDouble();
                System.out.print("Nhập Số lượng mới: ");
                int quantitySua = sc.nextInt();
                sc.nextLine();
                System.out.print("Nhập CPU mới: ");
                String cpuSua = sc.nextLine();
                System.out.print("Nhập RAM mới: ");
                int ramSua = sc.nextInt();
                System.out.print("Nhập Storage mới: ");
                int storageSua = sc.nextInt();
                sc.nextLine();
                System.out.print("Nhập GPU mới: ");
                String gpuSua = sc.nextLine();

                LapTop lapTopSua = new LapTop(idSua, nameSua, brandSua, priceSua, quantitySua, cpuSua, ramSua, storageSua, gpuSua);
                qlDanhSachLapTop.suaLapTop(idSua, lapTopSua);
                break;
                case 5:
                if (!auth.hasAuthorityManager(e, "M")) {
                    System.out.println("Bạn không có quyền");
                    break;
                    }
                File file = new File("DSLapTop.data");
                    qlDanhSachLapTop.ghiDuLieuXuongFile(file);
                    break;
                case 6:
                if (!auth.hasAuthorityManager(e, "M")) {
                    System.out.println("Bạn không có quyền");
                    break;
                    }
                    qlDanhSachLapTop.xoaHetLapTop();
                    break;
                case 7:
                if (!auth.hasAuthorityManager(e, "M")) {
                    System.out.println("Bạn không có quyền");
                    break;
                    }
                    sc.nextLine();
                    System.out.print("Nhập ID: ");
                    String empId = sc.nextLine();
                    System.out.print("Nhập Tên: ");
                    String empName = sc.nextLine();
                    System.out.print("Nhập Username: ");
                    String empUserName = sc.nextLine();
                    System.out.print("Nhập Password: ");
                    String empPassword = sc.nextLine();
                    System.out.print("Nhập quyền hạn: ");
                    String au = sc.nextLine();
                    Employee employee = new Employee(empId, empName, empUserName, empPassword, au);
                    qlDSNhanVien.themNhanVien(employee);
                    break;
                case 8:
                if (!auth.hasAuthorityManager(e, "M")) {
                    System.out.println("Bạn không có quyền");
                    break;
                    }
                    qlDSNhanVien.hienThiDanhSach();
                    break;
                case 9:
                if (!auth.hasAuthorityManager(e, "M")) {
                    System.out.println("Bạn không có quyền");
                    break;
                    }
                    File file1 = new File("NhanVien.data");
                    qlDSNhanVien.ghiDuLieuXuongFile(file1);
                    break;
                case 10:
                    if (!auth.hasAuthorityManager(e, "M")) {
                    System.out.println("Bạn không có quyền");
                    break;
                    }
                    qlDSNhanVien.xoaHetNhanVien();
                    break;
                case 11:
                if (!auth.hasAuthorityManager(e, "M")) {
                    System.out.println("Bạn không có quyền");
                    break;
                    }
                sc.nextLine();
                System.out.print("Nhập ID Nhân Viên cần sửa: ");
                String idSuaNV = sc.nextLine();
                System.out.print("Nhập Tên mới: ");
                String nameSuaNV = sc.nextLine();
                System.out.print("Nhập Username mới: ");
                String userNameSuaNV = sc.nextLine();
                System.out.print("Nhập Password mới: ");
                String passwordSuaNV = sc.nextLine();
                System.out.print("Nhập quyền hạn mới: ");
                String auSuaNV = sc.nextLine();
                Employee empSua = new Employee(idSuaNV, nameSuaNV, userNameSuaNV, passwordSuaNV, auSuaNV);
                qlDSNhanVien.suaNhanVien(idSuaNV, empSua);

                break;
                case 12:
                if (!auth.hasAuthorityManager(e, "M")) {
                    System.out.println("Bạn không có quyền");
                    break;
                    }
                    sc.nextLine();
                    System.out.print("Nhập ID Nhân Viên cần xóa: ");
                    String idXoaNV = sc.nextLine();
                    Employee empXoa = new Employee(idXoaNV);
                    qlDSNhanVien.xoaNhanVien(empXoa);

                    break;
                case 13:
                if (!auth.hasAuthorityManager(e, "M")) {
                    System.out.println("Bạn không có quyền");
                    break;
                    }
                    String invoiceId = UUID.randomUUID().toString().substring(0, 8); // Tạo ID hóa đơn ngẫu nhiên
                    Invoice invoice = new Invoice(invoiceId, e.getId(), e.getName());

                    boolean addingItems = true;
                    while (addingItems) {
                        sc.nextLine();
                        System.out.print("Nhập ID Laptop để thêm vào hóa đơn (hoặc 'done' để hoàn tất): ");
                        String lapId = sc.nextLine();
                        if (lapId.equalsIgnoreCase("done")) {
                            addingItems = false;
                            continue;
                        }
                        LapTop foundLap = null;
                        for (LapTop lt : qlDanhSachLapTop.danhSachLapTop) { 
                            if (lt.getId().equals(lapId)) {
                                foundLap = lt;
                                break;
                            }
                        }
                        if (foundLap == null) {
                            System.out.println("Không tìm thấy Laptop với ID này!");
                            continue;
                        }
                        System.out.print("Nhập số lượng: ");
                        int qty = sc.nextInt();
                        sc.nextLine(); // Consume newline
                        try {
                            invoice.addItem(foundLap, qty);
                            // Trừ số lượng từ kho
                            foundLap.setQuantity(foundLap.getQuantity() - qty);
                            System.out.println("Đã thêm sản phẩm vào hóa đơn.");
                        } catch (IllegalArgumentException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                    if (!invoice.getItems().isEmpty()) {
                        qlDSInvoice.themInvoice(invoice);
                        System.out.println("Hóa đơn đã được tạo:");
                        System.out.println(invoice);
                    } else {
                        System.out.println("Hóa đơn rỗng, không lưu.");
                    }
                    qlDanhSachLapTop.ghiDuLieuXuongFile(new File("DSLapTop.data")); // Cập nhật lại dữ liệu laptop sau khi xuất hóa đơn
                    qlDSInvoice.ghiDuLieuXuongFile(new File("Invoice.data")); // Lưu hóa đơn mới xuất ra file
                    break;
                case 14:
                if (!auth.hasAuthorityManager(e, "M")) {
                    System.out.println("Bạn không có quyền");
                    break;
                    }
                    qlDSInvoice.hienThiDanhSach();
                    break;
                case 15:
                if (!auth.hasAuthorityManager(e, "M")) {
                    System.out.println("Bạn không có quyền");
                    break;
                    }
                    qlDSInvoice.xoaHetInvoice();
                    break;
                default:
                    break;
            }
        } while (luaChon != 0);
    }
}

