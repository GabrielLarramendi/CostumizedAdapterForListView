package dominando.android.adaptercostumizado.adapters;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import dominando.android.adaptercostumizado.model.Vehicle;
import kotlin.Lazy;

public class VehicleAdapterInJava extends BaseAdapter {
    private Context ctx;

    private final List<Vehicle> vehicles = new ArrayList<>();


    public VehicleAdapterInJava(Context ctx) {
        this.ctx = ctx;
    }

    public Context getCtx() {
        return ctx;
    }

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(int position) {
        vehicles.remove(position);
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public int getCount() {
        return vehicles.size();
    }

    @Override
    public Object getItem(int position) {
        return vehicles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(String.valueOf(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
