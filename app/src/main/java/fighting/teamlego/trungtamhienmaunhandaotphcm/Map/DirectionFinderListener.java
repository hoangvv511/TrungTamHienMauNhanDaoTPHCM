package fighting.teamlego.trungtamhienmaunhandaotphcm.Map;

import android.location.Location;
import android.support.annotation.NonNull;

import java.util.List;

public interface DirectionFinderListener {
    void onDirectionFinderStart();
    void onDirectionFinderSuccess(List<Route> route);

    boolean onMyLocationButtonClick();

    void onMyLocationClick(@NonNull Location location);
}