package lesson6_HW;

public class Dog extends Animal{

    private int distanceSwimming;

    public Dog(String name, String color, int age){
        super(name, color, age);
        this.distanceRunning = DEFAULT_RUNNING_DISTANCE_FOR_DOG;
        this.jumpHeight = DEFAULT_JUMP_HEIGHT_FOR_DOG;
        this.distanceSwimming = DEFAULT_SWIMMING_DISTANCE_FOR_DOG;
    }

    @Override
    public String toString() {
        return  "Имя: " + name +
                ", цвет: " + color +
                ", возраст: " + age +
                ", высота прыжка: " + jumpHeight + "м" +
                ", дистанция бега: " + distanceRunning + "м" +
                ", дистанция плавания: " + distanceSwimming + "м";
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
        return distance <= distanceSwimming;
    }

    @Override
    public void setDistanceSwimming(int distanceSwimming) {
        this.distanceSwimming = distanceSwimming;
    }

    @Override
    public int getDistanceSwimming() {
        return distanceSwimming;
    }

}
