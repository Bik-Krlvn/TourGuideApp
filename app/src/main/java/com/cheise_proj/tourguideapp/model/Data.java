package com.cheise_proj.tourguideapp.model;

import android.content.Context;

import com.cheise_proj.tourguideapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Data object provides static data for place model
 */
public class Data {
    /**
     * Get list of monuments places
     *
     * @param context requires context
     * @return List<Place>
     */
    public static List<Place> getMonument(Context context) {
        List<Place> data = new ArrayList<>();
        String[] name = context.getResources().getStringArray(R.array.monument_names_array);
        int[] imageIds = {
                R.drawable.paris___palais_du_luxembourg,
                R.drawable.bilhetes_for_centro_pompidou,
                R.drawable.lesinvalidesfull,
                R.drawable.op_ra_garnier,
        };
        String[] description = context.getResources().getStringArray(R.array.monument_description_array);
        for (int i = 0; i < name.length; i++) {
            data.add(new Place(i, name[i], imageIds[i], description[i]));
        }
        return data;
    }

    /**
     * Get list of shopping places
     *
     * @param context requires context
     * @return List<Place>
     */
    public static List<Place> getShopping(Context context) {
        List<Place> data = new ArrayList<>();
        String[] name = context.getResources().getStringArray(R.array.shopping_names_array);
        int[] imageIds = {
                R.drawable.herm_s,
                R.drawable.guerlain,
                R.drawable.galeries_lafayette,
                R.drawable.louis_vuitton,
        };
        String[] description = context.getResources().getStringArray(R.array.shopping_description_array);
        for (int i = 0; i < name.length; i++) {
            data.add(new Place(i, name[i], imageIds[i], description[i]));
        }
        return data;
    }

    /**
     * Get list of hotel places
     *
     * @param context requires context
     * @return List<Place>
     */
    public static List<Place> getHotel(Context context) {
        List<Place> data = new ArrayList<>();
        String[] name = context.getResources().getStringArray(R.array.hotel_names_array);
        int[] imageIds = {
                R.drawable.la_belle_france,
                R.drawable.la_coorniche,
                R.drawable.hotel_byblos,
                R.drawable.hotel_du_palais,
        };
        String[] description = context.getResources().getStringArray(R.array.hotel_description_array);
        for (int i = 0; i < name.length; i++) {
            data.add(new Place(i, name[i], imageIds[i], description[i]));
        }
        return data;
    }

    /**
     * Get list of night places
     *
     * @param context requires context
     * @return List<Place>
     */
    public static List<Place> getNight(Context context) {
        List<Place> data = new ArrayList<>();
        String[] name = context.getResources().getStringArray(R.array.night_names_array);
        int[] imageIds = {
                R.drawable.les_berges_de_seine,
                R.drawable.quai_saint_bernard,
                R.drawable.bassin_de_la_villette,
                R.drawable.les_bateaux_mouches,
        };
        String[] description = context.getResources().getStringArray(R.array.night_description_array);
        for (int i = 0; i < name.length; i++) {
            data.add(new Place(i, name[i], imageIds[i], description[i]));
        }
        return data;
    }
}
