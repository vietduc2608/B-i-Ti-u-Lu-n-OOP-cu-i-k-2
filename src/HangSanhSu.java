import java.util.Date;

public class HangSanhSu extends HangHoa{
    private String nhaSanXuat;
    private Date ngayNhapKho;

    public HangSanhSu(){
        
    }

    public HangSanhSu(String maHang, String tenHang, double soLuongTonKho, double donGia, String nhaSanXuat,
            Date ngayNhapKho) {
        super(maHang, tenHang, soLuongTonKho, donGia);
        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhapKho = ngayNhapKho;
    }



    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public Date getNgayNhapKho() {
        return ngayNhapKho;
    }

    public void setNgayNhapKho(Date ngayNhapKho) {
        this.ngayNhapKho = ngayNhapKho;
    }

    @Override
    public String toString() {
        return "-HANG SANH SU \nNgay Nhap Kho: " + ngayNhapKho + " Nha San Xuat: " + nhaSanXuat + super.toString();
    }
}
