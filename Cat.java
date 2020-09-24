package lesson6_HW;

public class Cat extends Animal{

    public Cat(String name, String color, int age){
        super(name, color, age);
        this.distanceRunning = DEFAULT_RUNNING_DISTANCE_FOR_CAT;
        this.jumpHeight = DEFAULT_JUMP_HEIGHT_FOR_CAT;
    }

    @Override
    public String toString() {
        return  "Имя: " + name +
                ", цвет: " + color +
                ", возраст: " + age +
                ", высота прыжка: " + jumpHeight + "м" +
                ", дистанция бега: " + distanceRunning + "м";
    }

    @Override
    public void setDistanceSwimming(int distanceSwimming) {
        System.out.println("Кот не умеет плвать!!!");
    }

    @Override
    public int getDistanceSwimming() {
        return 0;
    }

    @Override
    public boolean run(int distance) {
        return distance <= distanceRunning;
    }

    @Override
    public boolean jump(double height) {
        return height <= jumpHeight;
    }

    @Override
    public boolean swim(int distance) {
        return false;
    }
}
