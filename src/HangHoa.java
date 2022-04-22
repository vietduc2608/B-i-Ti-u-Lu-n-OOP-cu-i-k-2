import java.text.NumberFormat;
import java.util.Locale;

public abstract class HangHoa {
    private String maHang;
    private String tenHang;
    private double soLuongTonKho;
    private double donGia;

    public HangHoa(){}

    public HangHoa(String maHang, String tenHang, double soLuongTonKho, double donGia) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.soLuongTonKho = soLuongTonKho;
        this.donGia = donGia;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        if(maHang != null){
            this.maHang = maHang;
        }else{
            System.out.println("Ma hang ko duoc de trong!!!");
        }
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        if(tenHang != null){
            this.tenHang = tenHang;
        }else{
            System.out.println("Ten hang ko duoc rong!!!");
        }
    }

    public double getSoLuongTonKho() {
        return soLuongTonKho;
    }

    public void setSoLuongTonKho(double soLuongTonKho) {
        if(soLuongTonKho >= 0){
            this.soLuongTonKho = soLuongTonKho;
        }else{
            System.out.println("So luong phai lon hon hoac bang 0");
        }
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        if(donGia > 0){
            this.donGia = donGia;
        }else{
            System.out.println("Don gia phai lon hon 0");
        }
    }

    public String getFileLine(){
        return maHang + "," + tenHang + "," + donGia + "," +  soLuongTonKho;
    }

    @Override
    public String toString() {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat tienViet = NumberFormat.getCurrencyInstance(localeVN);
        String str = tienViet.format(donGia);
        return "\nDon Gia: " + donGia + " Ma Hang: " + maHang + " So Luong Ton Kho: " + soLuongTonKho + " Ten Hang: "
                + tenHang;
    }

    
    

    
    

    
}


