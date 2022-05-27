package com.company;

enum Size{
    XXS(32){
        @Override
        public String getDescription(){
            return "Детский размер";
        }
    },
    XS(34),
    S(36),
    M(38),
    L(40);

    int euroSize;

    Size(int euroSize) {
        this.euroSize = euroSize;
    }

    public String getDescription(){
        return "Взрослый размер";
    }
    public String toString(){
        return name() + " (RU: " + euroSize + ") " + getDescription();
    }
}

abstract class Clothes{
    Size size;
    String color;
    double price;

    Clothes(Size size, String color, double price){
        this.size = size;
        this.price = price;
        this.color = color;
    }
    public Size getSize(){
        return size;
    }
    public double getPrice(){
        return price;
    }
    public String getColor(){
        return color;
    }
}

class Shop{
    void dressAMan(Clothes[] clothes){
        System.out.println("\n" + "Мужская одежда ");
        for(Clothes cloth : clothes){
            if(cloth instanceof MensClothing){
                System.out.println(cloth);
            }
        }
    }
    void dressAWoman(Clothes[] clothes){
        System.out.println("\n" + "Женская одежда ");
        for(Clothes cloth : clothes){
            if(cloth instanceof WomenClothing){
                System.out.println(cloth);
            }
        }
    }

    interface MensClothing{
        default void dressAmen(){
            System.out.println("Одеть мужчину ");
        }
    }

    interface WomenClothing{
        default void dressAwomen(){
            System.out.println("Одеть женщину ");
        }
    }

    public static class Tshirt extends Clothes implements MensClothing, WomenClothing{
        Tshirt (Size size, String color, double price){
            super(size, color, price);
        }

        public String toString() {
            return "\n" + "Размер футболки " + getSize() + "\n" + "Цвет: " + getColor() + "\n" + "Цена: " + getPrice() + " рублей";
        }
    }

    public static class Trousers extends Clothes implements MensClothing, WomenClothing{
        Trousers (Size size, String color, double price){
            super(size, color, price);
        }

        public String toString() {
            return "\n" + "Размер штанов " + getSize() + "\n" + "Цвет: " + getColor() + "\n" + "Цена: " + getPrice() + " рублей";
        }
    }

    public static class Skirt extends Clothes implements WomenClothing{
        Skirt (Size size, String color, double price){
            super(size, color, price);
        }

        public String toString() {
            return "\n" + "Размер юбки " + getSize() + "\n" + "Цвет: " + getColor() + "\n" + "Цена: " + getPrice() + " рублей";
        }
    }

    public static class Tie extends Clothes implements MensClothing{
        Tie (Size size, String color, double price){
            super(size, color, price);
        }

        public String toString() {
            return "\n" + "Размер галстука " + getSize() + "\n" + "Цвет: " + getColor() + "\n" + "Цена: " + getPrice() + " рублей";
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Clothes[] clothes = {
                new Shop.Tshirt(Size.XXS, "Белая", 5500),
                new Shop.Tshirt(Size.XS, "Черная", 5500),
                new Shop.Trousers(Size.L, "Чёрные", 9000),
                new Shop.Trousers(Size.M, "Серые", 9000),
                new Shop.Skirt(Size.M, "Синия", 6000),
                new Shop.Skirt(Size.L, "Черная", 6000),
                new Shop.Tie(Size.M, "Синий", 2000),
                new Shop.Tie(Size.M, "Красный", 1500),
        };

        Shop shop = new Shop();
        shop.dressAMan(clothes);
        shop.dressAWoman(clothes);
    }
}