package com.example.simpleparadox.listycity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities){
        super(context,0, cities);
        this.cities = cities;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * get size of cities list
     * @return
     */
    public int getCount() {
        return cities.size();
    }

    /**
     * add a city object into the list
     * @param city - city to add
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * return whether or not the specified city is in the list
     * @param city - city to check
     */
    public boolean hasCity(City city){
        for (int index = 0; index < cities.size(); index++) {
            City currentCity = cities.get(index);

            if(currentCity.getCityName().equals(city.getCityName()) && currentCity.getProvinceName().equals(city.getProvinceName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * delete a specified city, if it exists
     * @param city - city to delete
     */
    public void deleteCity(City city) {
        if(this.hasCity(city)) {
            for (int index = 0; index < cities.size(); index++) {
                City currentCity = cities.get(index);

                if(currentCity.getCityName().equals(city.getCityName()) && currentCity.getProvinceName().equals(city.getProvinceName())) {
                    cities.remove(index);
                    break;
                }
            }
        }
    }

    public int countCities() {
        return this.getCount();
    }


}
