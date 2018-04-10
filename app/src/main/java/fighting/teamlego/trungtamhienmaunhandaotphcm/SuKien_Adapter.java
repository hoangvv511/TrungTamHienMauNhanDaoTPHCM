package fighting.teamlego.trungtamhienmaunhandaotphcm;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SuKien_Adapter extends BaseAdapter {
    ArrayList<BaiViet> arrayListSuKien;
    Context context;

    public SuKien_Adapter(ArrayList<BaiViet> baiVietArrayList, Context context) {
        this.arrayListSuKien = baiVietArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayListSuKien.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListSuKien.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.item_baiviet, null);
        TextView tv_TieuDe =  view.findViewById(R.id.tv_tieude);
        TextView tv_NgayDang = view.findViewById(R.id.tv_ngaydangbai);
        TextView tv_NoiDungMau = view.findViewById(R.id.tv_noidungmau);
        ImageView imv_sukien = view.findViewById(R.id.imv_baiviet);
        //baiviet
        BaiViet baiViet = (BaiViet) getItem(i);
        tv_TieuDe.setText(baiViet.TieuDe);
        tv_NgayDang.setText(baiViet.NgayDang);
        tv_NoiDungMau.setText(baiViet.NoiDung);
        if(baiViet.HinhAnh != null) {
            Picasso.get().load("http:" + baiViet.HinhAnh).into(imv_sukien);
        }
        else
        {
            imv_sukien.setEnabled(false);
            imv_sukien.setVisibility(view.GONE);
        }
        return view;
    }
}
