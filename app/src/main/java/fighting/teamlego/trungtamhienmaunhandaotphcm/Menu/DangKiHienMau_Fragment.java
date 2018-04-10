package fighting.teamlego.trungtamhienmaunhandaotphcm.Menu;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import fighting.teamlego.trungtamhienmaunhandaotphcm.MainActivity;
import fighting.teamlego.trungtamhienmaunhandaotphcm.R;
import fighting.teamlego.trungtamhienmaunhandaotphcm.UserInformation;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class DangKiHienMau_Fragment extends Fragment {

    EditText editTextHoTen, editTextNgaySinh, editTextDiaChi, editTextEmail, editTextDienThoai, editTextCMT;
    RadioGroup radioGroup;
    RadioButton radioButtonNam, radioButtonNu;

    Button btnDangKy;

    String HoTen, NgaySinh, GioiTinh, DiaChi, Email, DienThoai, CMT;
    DatabaseReference databaseRefence = FirebaseDatabase.getInstance().getReference();
    TextInputLayout textInputLayout_Hoten, textInputLayout_Ngaysinh, textInputLayout_Diachi, textInputLayout_Email, textInputLayout_Dienthoai, textInputLayout_CMT;
    public DangKiHienMau_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dang_ki_hien_mau_, container, false);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Phiếu đăng kí hiến máu");
        radioGroup = (RadioGroup)view.findViewById(R.id.radioGroup);
        editTextHoTen = view.findViewById(R.id.edtHoTen);
        editTextNgaySinh = view.findViewById(R.id.edtNgaySinh);
        editTextDiaChi = view.findViewById(R.id.edtDiaChi);
        editTextEmail = view.findViewById(R.id.edtEmail);
        editTextDienThoai = view.findViewById(R.id.edtDienThoai);
        editTextCMT = view.findViewById(R.id.edtCMT);
        radioButtonNam = view.findViewById(R.id.radioButtonNam);
        radioButtonNu = view.findViewById(R.id.radioButtonNu);
        textInputLayout_Hoten = view.findViewById(R.id.inputLayoutHoten);
        textInputLayout_Ngaysinh = view.findViewById(R.id.inputLayoutNgaysinh);
        textInputLayout_Diachi = view.findViewById(R.id.inputLayoutDiachi);
        textInputLayout_Dienthoai = view.findViewById(R.id.inputLayoutDienthoai);
        textInputLayout_Email = view.findViewById(R.id.inputLayoutEmail);
        textInputLayout_CMT = view.findViewById(R.id.inputLayoutCMT);
        btnDangKy = (Button)view.findViewById(R.id.buttonDangKy);

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HoTen = editTextHoTen.getText().toString().trim();
                NgaySinh = editTextNgaySinh.getText().toString().trim();
                DiaChi = editTextDiaChi.getText().toString().trim();
                Email = editTextEmail.getText().toString().trim();
                DienThoai = editTextDienThoai.getText().toString().trim();
                CMT = editTextCMT.getText().toString().trim();
                if(radioButtonNam.isChecked() == true)
                {
                    GioiTinh = radioButtonNam.getText().toString().trim();
                }
                else
                {
                    GioiTinh = radioButtonNu.getText().toString().trim();
                }
                if(TextUtils.isEmpty(HoTen) || TextUtils.isEmpty(NgaySinh) || TextUtils.isEmpty(DiaChi) || TextUtils.isEmpty(Email) || TextUtils.isEmpty(DienThoai) || TextUtils.isEmpty(CMT) || TextUtils.isEmpty(GioiTinh))
                {
                    Toast.makeText(getActivity(), "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    UserInformation thongTin = new UserInformation(HoTen, NgaySinh, GioiTinh, DiaChi, Email, DienThoai, CMT);
                    databaseRefence.child("Chứng minh thư").child(CMT).setValue(thongTin);
                    Toast.makeText(getContext(), "Đăng ký thành công !", Toast.LENGTH_SHORT).show();
                    editTextHoTen.setText("");
                    editTextNgaySinh.setText("");
                    editTextDiaChi.setText("");
                    editTextEmail.setText("");
                    editTextDienThoai.setText("");
                    editTextCMT.setText("");
                }
            }
        });
        return view;
    }

}
