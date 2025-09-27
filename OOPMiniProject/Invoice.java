// Invoice.java
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Invoice implements Serializable {
    private String invoiceId;
    private String employeeId;
    private String employeeName;
    private ArrayList<InvoiceItem> items;
    private double totalAmount;
    private Date creationDate;

    public Invoice(String invoiceId, String employeeId, String employeeName) {
        this.invoiceId = invoiceId;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.items = new ArrayList<>();
        this.totalAmount = 0.0;
        this.creationDate = new Date();
    }

    public void addItem(LapTop laptop, int quantity) {
        if (quantity > laptop.getQuantity()) {
            throw new IllegalArgumentException("Số lượng yêu cầu vượt quá tồn kho!");
        }
        InvoiceItem item = new InvoiceItem(laptop, quantity);
        items.add(item);
        totalAmount += item.getSubtotal();
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public ArrayList<InvoiceItem> getItems() {
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--------------------------\n");
        sb.append("Hóa đơn ID: ").append(invoiceId).append("\n");
        sb.append("Nhân viên: ").append(employeeName).append(" (ID: ").append(employeeId).append(")\n");
        sb.append("Ngày xuất: ").append(creationDate).append("\n");
        sb.append("Chi tiết sản phẩm:\n");
        for (InvoiceItem item : items) {
            sb.append(item).append("\n");
        }
        sb.append("Tổng tiền: $").append(totalAmount).append("\n");
        sb.append("--------------------------\n");
        return sb.toString();
    }
}

// Lớp phụ cho chi tiết hóa đơn
class InvoiceItem implements Serializable {
    private LapTop laptop;
    private int quantity;
    private double subtotal;

    public InvoiceItem(LapTop laptop, int quantity) {
        this.laptop = laptop;
        this.quantity = quantity;
        this.subtotal = laptop.getPrice() * quantity;
    }

    public LapTop getLaptop() {
        return laptop;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    @Override
    public String toString() {
        return " - " + laptop.getName() + " (ID: " + laptop.getId() + ") x " + quantity + " = $" + subtotal;
    }
}