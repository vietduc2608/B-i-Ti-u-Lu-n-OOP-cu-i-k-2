public class HangDienMay extends HangHoa {
    int tGBH;
    double congSuat;

    public HangDienMay(){

    }

    public HangDienMay(int tGBH, double congSuat) {
        this.tGBH = tGBH;
        this.congSuat = congSuat;
    }

    public HangDienMay(int maHang, String tenHang, double soLuongTonKho, double donGia, int tGBH, double congSuat) {
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
        return "HangDienMay [congSuat=" + congSuat + ", tGBH=" + tGBH + "]";
    }
}
