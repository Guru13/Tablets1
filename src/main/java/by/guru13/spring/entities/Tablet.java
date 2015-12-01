package by.guru13.spring.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Arrays;

/**
 *Класс, который описывает планшет и включает все необходимые геттеры и сеттеры
 *<p>
 *
 * @author Alexey Guryanchyck
 */
@Entity
@Table(name = "TABLET")
public class Tablet {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 2, max = 100, message = "{Size.tablet.brand}")
    private String brand;


    private float price;

    private int year;
    private int ram;
    private int rom;

    @Size(min = 2, max = 100, message = "{Size.tablet.system}")
    private String system;

    private int battery;

    @Size(min = 2, max = 100, message = "{Size.tablet.color}")
    private String color;

    private int screenSize;
    private byte[] image;
    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getRom() {
        return rom;
    }

    public void setRom(int rom) {
        this.rom = rom;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tablet{");
        sb.append("id=").append(id);
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", price=").append(price);
        sb.append(", year=").append(year);
        sb.append(", ram=").append(ram);
        sb.append(", rom=").append(rom);
        sb.append(", system='").append(system).append('\'');
        sb.append(", battery=").append(battery);
        sb.append(", color='").append(color).append('\'');
        sb.append(", screenSize=").append(screenSize);
        sb.append('}');
        return sb.toString();
    }
}
