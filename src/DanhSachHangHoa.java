import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class DanhSachHangHoa {
    private List<HangHoa> dsHH = new ArrayList<>();
    HangHoa hangHoa = null;
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
    private Date ngaySanXuat, ngayHetHan, ngayNhapKho, hSD;
    private String nhaCungCap, nhaSanXuat;
    private int tGBH;
    private double congSuat;
    

    public Date gethSD() {
        return hSD;
    }

    public void sethSD(Date hSD) {
        this.hSD = hSD;
    }

    public HangHoa nhapDuLieu() { 
        HangHoa hangHoa = null;
        try{
            sc.nextLine();
        System.out.println("Nhap ma hang: ");
        String maHang = sc.nextLine();
        System.out.println("Nhap ten hang: ");
        String tenHang = sc.nextLine();
        System.out.println("Nhap so luong ton kho: ");
        double soLuongTonKho = sc.nextDouble();
        System.out.println("Don gia: ");
        double donGia = sc.nextDouble();

        System.out.println("Lua chon cua ban : [1: Hang Thuc Pham] [2: Hang Dien May] [3: Hang Sanh Su]");
        int lc = sc.nextInt();
        switch (lc) {
            case 1://hàng thực phẩm
                System.out.println("=============HANG THUC PHAM============");
                try {
                    sc.nextLine();
                    System.out.println("Nhap ngay san xuat: [dd/MM/yyyy]");
                    ngaySanXuat = sf.parse(sc.nextLine());
                    System.out.println("Nhap ngay het han: [dd/MM/yyyy]");
                    ngayHetHan = sf.parse(sc.nextLine());
                    System.out.println("Nhap nha cung cap: ");
                    nhaCungCap = sc.nextLine();

                } catch (Exception e) {

                }
                hangHoa = new HangThucPham(maHang, tenHang, soLuongTonKho, donGia, ngaySanXuat, ngayHetHan, nhaCungCap);
                break;

            case 2://hàng điện máy
                System.out.println("===HANG DIEN MAY===");
                System.out.println("Nhap thoi gian bao hanh: (thang) ");
                tGBH = sc.nextInt();
                System.out.println("Nhap cong suat: (W) ");
                congSuat = sc.nextDouble();
                sc.nextLine();
                hangHoa = new HangDienMay(maHang, tenHang, soLuongTonKho, donGia, tGBH, congSuat);

                break;

            case 3://hàng sành sứ
                System.out.println("===HANG SANH SU===");
                System.out.println("Nhap nha san xuat: ");
                nhaSanXuat = sc.nextLine();
                sc.nextLine();
                try {
                    System.out.println("Nhap ngay nhap kho: ");
                    ngayNhapKho = sf.parse(sc.nextLine());
                } catch (Exception e) {

                }
                break;
            default:
                System.out.println("xxx");
                break;
        }
    }catch(Exception e ){
        System.out.println("Nhap sai roi! Nhap lai di!!!");
    }
        return hangHoa;

    }

    public void nhapHangHoa(){
        String luaChon = null;
        do{
            HangHoa hangHoa = this.nhapDuLieu();
            this.themHangHoa(hangHoa);
            System.out.println("Ban Co Muon Nhap Tiep Hay Khong? [Y/N]");
            luaChon = sc.nextLine();
        }while(luaChon.equals("Y") || luaChon.equals("y"));
    }

    public void themHangHoa(HangHoa hangHoa) {
        dsHH.add(hangHoa);
    }

    public void suaHangHoa(int viTri, HangHoa hangHoa) {
        this.dsHH.set(viTri, hangHoa);
    }

    public boolean xoaHangHoa(String maHang){
        for (HangHoa hangHoa : dsHH) {
            if (hangHoa.getMaHang().equals(maHang)) {
                dsHH.remove(hangHoa);
                System.out.println("Da xoa thanh cong");
                return true;

            } else {
              
                System.out.println("Ma hang khong ton tai!");
            }
            System.out.println("Xoa khong thanh cong");
            
        }
        return false;
        
    }

    public void sapXep(){
        Collections.sort(dsHH, (a, b) -> (int) (a.getDonGia() - b.getDonGia()));
    }

    public void inThongTin() {
        System.out.println("==========THONG TIN SAN PHAM=========");
        for (HangHoa hangHoa : dsHH) {
            System.out.println(hangHoa);
        }
    }

   
    // public boolean kiemTraHSD(){
    //     boolean isHetHan = false;//con han

    //     if(this.ngayHetHan.before(new Date())){
    //         isHetHan  = true;
    //         System.out.println("Het han roi ! Dung an !!!!");
    //     }else{
    //         System.out.println("Con han su dung an di !!!!!");
    //     }
    //     return isHetHan;

    // }


    public HangHoa timkiemHangHoa(String maHang) {
        HangHoa hh = null;
        for (HangHoa hangHoa : dsHH) {
            if (hangHoa.getMaHang().equalsIgnoreCase(maHang)) {
                hh = hangHoa;
                System.out.println(hangHoa);
                break;
            }
            else{

            }
         
        }
        return hh;
            
    }

    public void saveFile(){
        System.out.println("===Luu Thanh Cong===");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("hanghoa.txt", true);
            //luu du lieu
            for (HangHoa hangHoa : dsHH) {
                String line = hangHoa.getFileLine();
                //chuyen string to byte[]
                byte[] b = line.getBytes("utf8");
                //save
                fos.write(b); 
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {   
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }

    public List<HangHoa> readFile(){
        try {
            FileReader fr = new FileReader("hanghoa.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            while(true){
                line = br.readLine();
                if(line == null){
                    break;
                }
                System.out.println(line);

            }
        } catch (Exception e) {
         
        }
        return dsHH;
    }

    public void menu(){
        do{
            System.out.println("==========================MENU============================");
            System.out.println("=1====================Them Hang Hoa=======================");
            System.out.println("=2====================Xem Thong Tin=======================");
            System.out.println("=3=====================Xoa Hang Hoa=======================");
            System.out.println("=4=====================Sua Hang Hoa=======================");
            System.out.println("=5===================Sap Xep Hang Hoa=====================");
            System.out.println("=6=================Kiem Tra Han Su Dung===================");
            System.out.println("=7=======================Luu File=========================");
            System.out.println("=8=======================Doc File=========================");
            System.out.println("=9=======================Tim Kiem=========================");
            System.out.println("=0=========================THOAT==========================");
            System.out.println("Nhap Lua Chon Cua Ban: ");
            int lc = sc.nextInt();
            switch(lc){
                case 0:
                break;
                case 1:nhapHangHoa();
                break;
                case 2:inThongTin();
                break;
                case 3:sc.nextLine();
                System.out.println("Nhap ma hang can xoa: ");
                String maHang = sc.nextLine();
                xoaHangHoa(maHang);
                break;
                case 4:System.out.println("Hang Hoa Can Sua: ");
                // String maHang = sc.nextLine();
                // suaHangHoa(maHang, hangHoa);
                break;
                case 5:sapXep();
                System.out.println("Hang Hoa Da Duoc Sap Xep: ");
                // inThongTin();
                inThongTin();
                break;
                case 6:kiemTraHSD();
                break;
                case 7:saveFile();
                break;
                case 8:readFile();
                break;
                case 9:sc.nextLine();
                System.out.println("Nhap ma hang can tim: ");
                String mH = sc.nextLine();
                timkiemHangHoa(mH);
                break;
                default: System.out.println("Nhap lua chon sai!!! Vui long nhap lai");
                break;
            }            
        }while(true);
    }

    public void duLieuMoi(){
        try {
            String sDate1 = "26/08/2022";  
            String sDate2 = "20/10/2022";  
            String sDate3 = "01/03/2022";  
            String sDate4 = "07/07/2022";  
            String sDate5 = "25/12/2022";  
            String sDate6 = "01/02/2022";  
            SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
            Date date1=sf.parse(sDate1);
            Date date2=sf.parse(sDate2);
            Date date3=sf.parse(sDate3);
            Date date4=sf.parse(sDate4);
            Date date5=sf.parse(sDate5);
            Date date6=sf.parse(sDate6);
            HangHoa hangHoa1 = new HangDienMay("DM001", "Tu Lanh", 100, 50000, 12, 30);
            HangHoa hangHoa2 = new HangDienMay("DM002", "May Dieu Hoa", 400, 60000, 24, 50);
            HangHoa hangHoa3 = new HangDienMay("DM003", "Quat Dien", 200, 30000, 6, 10);
            HangHoa hangHoa4 = new HangSanhSu("SS001", "Binh Hoa", 1000, 500, "Viet Duc", date1);
            HangHoa hangHoa5 = new HangSanhSu("SS002", "Chen Dia", 6000, 700, "Huynh Tin", date2);
            HangHoa hangHoa6 = new HangSanhSu("SS003", "Ly", 1000, 400, "Duc Tin", date3);
            HangHoa hangHoa7 = new HangThucPham("TP001", "Thit", 800, 30000, date4, date5, "Huy Ngo");
            HangHoa hangHoa8 = new HangThucPham("TP002", "Ca", 300, 5000, date6, date1, "Huynh Minh");
            HangHoa hangHoa9 = new HangThucPham("TP003", "Rau Cu", 230, 1500, date3, date2, "Minh Ngo");
            HangHoa hangHoa10 = new HangThucPham("TP004", "Trai Cay", 5000, 200, date1, date5, "Duckman");
            themHangHoa(hangHoa1);
            themHangHoa(hangHoa2);
            themHangHoa(hangHoa3);
            themHangHoa(hangHoa4);
            themHangHoa(hangHoa5);
            themHangHoa(hangHoa6);
            themHangHoa(hangHoa7);
            themHangHoa(hangHoa8);
            themHangHoa(hangHoa9);
            themHangHoa(hangHoa10);

        } catch (Exception e) {
            e.getCause();
        }
    }


     public void kiemTraHSD() {
        Date today = new Date();
        today.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String st = simpleDateFormat.format(today);
        if (this.gethSD().compareTo(today) < 0) {
            System.out.println("Hôm nay là ngày " + st + ", hàng hóa đã hết hạn ");
        } else {
            System.out.println("Hôm nay là ngày " + st + ", hàng hóa vẫn còn hạn ");
        }
    }

    // public HangHoa timKiemHangHoa(String maHang) {
    //     HangHoa hh = null;    
    //     for (HangHoa hangHoa : dsHH) {
    //         if (hangHoa.getMaHang().equalsIgnoreCase(maHang)) {
    //             hh = hangHoa;
    //             System.out.println(hangHoa);
    //             break;
    //         }
    //         else
    //         System.out.println(".....");
    //     }
    //     return hh;
    // }
    // public HangHoa timKiem(String maHang){
    //     return (HangHoa) this.dsHH.stream().filter(danhSachHangHoa -> danhSachHangHoa.getMaHang().equals(maHang).finFirst().orElse(null));
    // }

     // public void show(){
    //     this.dsHH.forEach(dsHH -> System.out.println(dsHH.toString()));
    // }
}
