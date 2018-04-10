package fighting.teamlego.trungtamhienmaunhandaotphcm;

public class UserInformation {
    String HoTen;
    String NgaySinh;
    String GioiTinh;
    String DiaChi;
    String Email;
    String DienThoai;
    String CMT;

    public UserInformation(){

    }

    public UserInformation(String hoTen, String ngaySinh, String gioiTinh, String diaChi, String email, String dienThoai, String CMT) {
        this.HoTen = hoTen;
        this.NgaySinh = ngaySinh;
        this.GioiTinh = gioiTinh;
        this.DiaChi = diaChi;
        this.Email = email;
        this.DienThoai = dienThoai;
        this.CMT = CMT;
    }
}
