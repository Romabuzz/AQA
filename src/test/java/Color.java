public class Color {
    private int id;
    private String name;
    private int year;
    private String color;
    private String pantone_value;

    // геттеры
    public int getId() { return id; }
    public String getName() { return name; }
    public int getYear() { return year; }
    public String getColor() { return color; }
    public String getPantone_value() { return pantone_value; }

    // сеттеры
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setYear(int year) { this.year = year; }
    public void setColor(String color) { this.color = color; }
    public void setPantone_value(String pantone_value) { this.pantone_value = pantone_value; }
}
