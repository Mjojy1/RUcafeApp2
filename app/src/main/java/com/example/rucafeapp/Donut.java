/**
 * @Author: Jack Zhong and Mathew Jojy
 */
package com.example.rucafeapp;
import android.os.Parcel;
import android.os.Parcelable;
/**
 * Donut class that extends MenuItem
 */
public class Donut extends MenuItem implements Parcelable{
    private double price;
    private String flavor;
    private int image;

    /**
     * Constructor for Donut
     *
     * @param flavor flavor of the donut
     * @param price  price of the donut
     */
    public Donut(String flavor, double price, int image){
        this.flavor = flavor;
        this.price = price;
        this.image = image;
    }
    public Donut(String flavor, double price){
        this.flavor = flavor;
        this.price = price;
        this.image = 0;
    }
    protected Donut(Parcel in) {
        price = in.readDouble();
        flavor = in.readString();
        image = in.readInt();
    }
    public static final Creator<Donut> CREATOR = new Creator<Donut>() {
        @Override
        public Donut createFromParcel(Parcel in) {
            return new Donut(in);
        }

        @Override
        public Donut[] newArray(int size) {
            return new Donut[size];
        }
    };

    public Double getPrice() {
        return price;
    }

    public String getFlavor() {
        return flavor;
    }
    public int getImage(){
        return image;
    }

    /**
     * Returns the price of the donut
     * @return price of the donut
     */
    @Override
    public Double price() {
        return price;
    }
    /**
     * Returns the string representation of the donut
     * @return string representation of the donut
     */
    @Override
    public String toString() {
        return "Donut{" +
                "'" + flavor + '\'' +
                ", price=" + price +
                '}';
    }
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(price);
        dest.writeString(flavor);
        dest.writeInt(image);
    }

}
