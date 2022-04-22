import java.text.SimpleDateFormat;
import java.util.Date;

public class HangThucPham extends HangHoa {
    private Date ngaySanXuat, ngayHetHan;
    private String nhaCungCap;

    public HangThucPham(){

    }

    public HangThucPham(String maHang, String tenHang, double soLuongTonKho, double donGia, Date ngaySanXuat,
            Date ngayHetHan, String nhaCungCap) {
        super(maHang, tenHang, soLuongTonKho, donGia);
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
        this.nhaCungCap = nhaCungCap;
    }


    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(Date ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        if(ngayHetHan != null){
            if(ngayHetHan.after(this.ngaySanXuat)){
            this.ngayHetHan = ngayHetHan;
        }else{
            System.out.println("Ngay het han phai sau ngay san xuat");
            this.ngayHetHan = new Date();
        }
     }else{
         System.out.println("Ngay het han khong duoc de trong!");
         this.ngayHetHan = new Date();
     }
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    @Override
    public String toString() {
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
        String str1 = sf.format(ngayHetHan);
        String str2 = sf.format(ngaySanXuat);
        return  "-HANG THUC PHAM \nNgay Het Han: " + str1 + " Ngay San Xuat: " + str2 + " Nha Cung Cap: " + nhaCungCap + super.toString() ;
    }
    
}
