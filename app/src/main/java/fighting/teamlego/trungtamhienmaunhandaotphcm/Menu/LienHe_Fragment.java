package fighting.teamlego.trungtamhienmaunhandaotphcm.Menu;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import fighting.teamlego.trungtamhienmaunhandaotphcm.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LienHe_Fragment extends DialogFragment {


    public LienHe_Fragment() {
        // Required empty public constructor
    }

    Button btnGoi;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lien_he_, container, false);
        btnGoi = (Button) view.findViewById(R.id.btnGoi);

        btnGoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "01886137291";
                Uri call = Uri.parse("tel:" + number);
                Intent surf = new Intent(Intent.ACTION_DIAL, call);
                startActivity(surf);
            }
        });

        return view;
    }
}
