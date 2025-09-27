import java.io.Serializable;

public class LapTop extends Product implements Comparable<LapTop>, Serializable {
    private String cpu;
    private int ram; // in GB
    private int storage; // in GB
    private String gpu; 

    public LapTop(String id, String name, String brand, double price, int quantity,
                  String cpu, int ram, int storage, String gpu) {
        super(id, name, brand, price, quantity);
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.gpu = gpu;
    }

    public LapTop(String id) { // Constructor dùng để xóa laptop theo ID
        super(id, "", "", 0.0, 0);
    }

    public String getCpu() {
        return cpu;
    }
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }
    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }
    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getGpu() {
        return gpu;
    }
    public void setGpu(String gpu) {
        this.gpu = gpu;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LapTop laptop = (LapTop) obj;
        return this.getId().equals(laptop.getId()); // so sánh theo ID
    }


    @Override
    public int compareTo(LapTop other) {
        return this.getId().compareTo(other.getId());
    }

    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }

    @Override
    public String toString() {
        return super.toString() +
               "CPU: " + cpu + "\n" +
               "RAM: " + ram + " GB\n" +
               "Storage: " + storage + " GB\n" +
               "GPU: " + gpu + "\n" +
               "--------------------------\n";
    }
    
}
