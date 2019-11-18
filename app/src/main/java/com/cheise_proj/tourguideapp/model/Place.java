package com.cheise_proj.tourguideapp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Place object provides attraction name and their images
 * class implement Parcelable
 */
public class Place implements Parcelable {
    private int id;
    private String name;
    private int imageResourceId;
    private String description;

    /**
     * @param id provide place id
     * @param name provide name of place
     * @param imageResourceId provide drawable resource id
     * @param description provide description of place
     */
    public Place(int id, String name, int imageResourceId, String description) {
        this.id = id;
        this.name = name;
        this.imageResourceId = imageResourceId;
        this.description = description;
    }

    protected Place(Parcel in) {
        id = in.readInt();
        name = in.readString();
        imageResourceId = in.readInt();
        description = in.readString();
    }

    public static final Creator<Place> CREATOR = new Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(imageResourceId);
        dest.writeString(description);
    }
}
