package fighting.teamlego.trungtamhienmaunhandaotphcm.Menu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

import fighting.teamlego.trungtamhienmaunhandaotphcm.BaiViet;
import fighting.teamlego.trungtamhienmaunhandaotphcm.MainActivity;
import fighting.teamlego.trungtamhienmaunhandaotphcm.R;
import fighting.teamlego.trungtamhienmaunhandaotphcm.SuKien_Adapter;
import fighting.teamlego.trungtamhienmaunhandaotphcm.WebView_BaiViet;


/**
 * A simple {@link Fragment} subclass.
 */
public class HoatDongCLB_Fragment extends Fragment {


    SuKien_Adapter suKien_adapter;
    ListView listViewSukien;
    ArrayList<BaiViet> baiVietArrayList;
    int sotrang;
    ImageButton imB_Down;
    int sotranghientai;
    String url = "http://hienmaunhandao.org.vn/blogs/hoat-dong-clb?page=1";
    public HoatDongCLB_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Hoạt động Câu lạc bộ");

        final View view = inflater.inflate(R.layout.fragment_su_kien_, container,false);
        listViewSukien = (ListView) view.findViewById(R.id.lv_sukien);
        baiVietArrayList = new ArrayList<>();
        imB_Down = view.findViewById(R.id.imB_down);
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String SoTrang = "";
                Document documentTrang = Jsoup.parse(response);
                if(documentTrang != null) {
                    Elements elements = documentTrang.select("div[class=col-lg-8 col-md-10 col-sm-6 col-xs-12 text-left]");
                    for (Element element : elements) {
                        Element elementTrang = element.getElementsByTag("a").last();
                        if (elementTrang != null) {
                            SoTrang = elementTrang.text();
                        }
                        sotrang = Integer.parseInt(SoTrang);
                        String url2 = "http://hienmaunhandao.org.vn/blogs/hoat-dong-clb?page=" + 1;
                        RequestQueue requestQueue2 = Volley.newRequestQueue(getActivity());
                        StringRequest stringRequest2 = new StringRequest(Request.Method.GET, url2, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                String HinhAnh = "";
                                String NgayDang = "";
                                String TieuDe = "";
                                String NoiDungMau = "";
                                String Link = "";
                                Document document = Jsoup.parse(response);
                                if(document != null)
                                {
                                    Elements elements = document.select("div[class=clearfix hentry col-lg-12]");
                                    for (Element element : elements)
                                    {
                                        Element elementHinhAnh = element.getElementsByTag("img").first();
                                        Element elementNgayDang = element.getElementsByTag("time").first();
                                        Element elementTieuDe = element.getElementsByTag("a").get(1);
                                        Element elementNoiDungMau = element.getElementsByTag("p").first();
                                        Element elementLink = element.getElementsByTag("a").first();
                                        if (elementLink != null)
                                        {
                                            Link = elementLink.attr("href");
                                        }
                                        if (elementHinhAnh != null)
                                        {
                                            HinhAnh = elementHinhAnh.attr("src");
                                        }
                                        if (elementNgayDang != null)
                                        {
                                            NgayDang = elementNgayDang.text();
                                        }
                                        if (elementTieuDe != null)
                                        {
                                            TieuDe = elementTieuDe.text();
                                        }
                                        if (elementNoiDungMau != null)
                                        {
                                            NoiDungMau = elementNoiDungMau.text();
                                        }
                                        baiVietArrayList.add(new BaiViet(TieuDe,NoiDungMau,NgayDang,HinhAnh,Link));
                                    }
                                    suKien_adapter = new SuKien_Adapter(baiVietArrayList, getActivity());
                                    listViewSukien.setAdapter(suKien_adapter);
                                    listViewSukien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                            WebView_BaiViet webView_baiViet = new WebView_BaiViet();
                                            Bundle bundle = new Bundle();
                                            bundle.putString("LINK","http://hienmaunhandao.org.vn" + baiVietArrayList.get(i).Link);
                                            webView_baiViet.setArguments(bundle);
                                            FragmentManager manager = getFragmentManager();
                                            manager.beginTransaction().replace(R.id.content_main, webView_baiViet, webView_baiViet.getTag()).commit();
                                        }
                                    });
                                }
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        });
                        requestQueue2.add(stringRequest2);
                    }
                }
                sotranghientai = 2;
                imB_Down.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(sotranghientai <= sotrang)
                        {
                            String url2 = "http://hienmaunhandao.org.vn/blogs/hoat-dong-clb?page=" + sotranghientai;
                            RequestQueue requestQueue2 = Volley.newRequestQueue(getActivity());
                            StringRequest stringRequest2 = new StringRequest(Request.Method.GET, url2, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    String HinhAnh = "";
                                    String NgayDang = "";
                                    String TieuDe = "";
                                    String NoiDungMau = "";
                                    String Link = "";
                                    Document document = Jsoup.parse(response);
                                    if(document != null)
                                    {
                                        Elements elements = document.select("div[class=clearfix hentry col-lg-12]");
                                        for (Element element : elements)
                                        {
                                            Element elementHinhAnh = element.getElementsByTag("img").first();
                                            Element elementNgayDang = element.getElementsByTag("time").first();
                                            Element elementTieuDe = element.getElementsByTag("a").get(1);
                                            Element elementNoiDungMau = element.getElementsByTag("p").first();
                                            Element elementLink = element.getElementsByTag("a").first();
                                            if (elementLink != null)
                                            {
                                                Link = elementLink.attr("href");
                                            }
                                            if (elementHinhAnh != null)
                                            {
                                                HinhAnh = elementHinhAnh.attr("src");
                                            }
                                            if (elementNgayDang != null)
                                            {
                                                NgayDang = elementNgayDang.text();
                                            }
                                            if (elementTieuDe != null)
                                            {
                                                TieuDe = elementTieuDe.text();
                                            }
                                            if (elementNoiDungMau != null)
                                            {
                                                NoiDungMau = elementNoiDungMau.text();
                                            }
                                            baiVietArrayList.add(new BaiViet(TieuDe,NoiDungMau,NgayDang,HinhAnh,Link));
                                        }
                                        suKien_adapter = new SuKien_Adapter(baiVietArrayList, getActivity());
                                        listViewSukien.setAdapter(suKien_adapter);
                                        listViewSukien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                                WebView_BaiViet webView_baiViet = new WebView_BaiViet();
                                                Bundle bundle = new Bundle();
                                                bundle.putString("LINK","http://hienmaunhandao.org.vn" + baiVietArrayList.get(i).Link);
                                                webView_baiViet.setArguments(bundle);
                                                FragmentManager manager = getFragmentManager();
                                                manager.beginTransaction().replace(R.id.content_main, webView_baiViet, webView_baiViet.getTag()).commit();
                                            }
                                        });
                                    }

                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            });
                            requestQueue2.add(stringRequest2);
                        }
                        sotranghientai++;
                    }
                });
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(stringRequest);

        return view;
    }

}
