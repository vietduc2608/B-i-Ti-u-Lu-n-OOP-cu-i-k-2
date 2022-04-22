public class HangDienMay extends HangHoa {
    int tGBH;
    double congSuat;

    public HangDienMay(){

    }

    public  HangDienMay(String maHang, String tenHang, double soLuongTonKho, double donGia, int tGBH, double congSuat) {
        super(maHang, tenHang, soLuongTonKho, donGia);
        this.tGBH = tGBH;
        this.congSuat = congSuat;
    }


    public int gettGBH() {
        return tGBH;
    }

    public void settGBH(int tGBH) {
        this.tGBH = tGBH;
    }

    public double getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(double congSuat) {
        this.congSuat = congSuat;
    }

    @Override
    public String toString() {
        return "-HANG DIEN MAY \nCong Suat: " + congSuat + "W" + " Thoi Gian Bao Hanh: " + tGBH + " thang" + super.toString();
    }
}
