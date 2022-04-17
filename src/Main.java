import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // HangHoa hangHoa = new HangThucPham(maHang, tenHang, soLuongTonKho, donGia, ngaySanXuat, ngayHetHan, nhaCungCap)
        // DanhSachHangHoa danhSachHangHoa = new DanhSachHangHoa();
        // danhSachHangHoa.themHangHoa(hangHoa);
        // danhSachHangHoa.inThongTin();
        
        DanhSachHangHoa danhSachHangHoa = new DanhSachHangHoa();
        danhSachHangHoa.nhapDuLieu();
        danhSachHangHoa.kiemTraHSD();
        danhSachHangHoa.inThongTin();
        
        // String lc = null;
        // do {
        //     HangHoa hangHoa = danhSachHangHoa.nhapHangHoa();
        //     danhSachHangHoa.themHangHoa(hangHoa);
        //     System.out.println("Ban co muon nhap tiep hay ko [Y], [N]");
        //     lc = danhSachHangHoa.sc.nextLine();
        // } while (lc.equals("Y"));

        // danhSachHangHoa.inThongTin();
        
    }
    

    
}
