package lesson6_HW;

public abstract class Animal {

    public static final int DEFAULT_RUNNING_DISTANCE_FOR_CAT = 200;
    public static final int DEFAULT_RUNNING_DISTANCE_FOR_DOG = 500;

    public static final double DEFAULT_JUMP_HEIGHT_FOR_CAT = 2;
    public static final double DEFAULT_JUMP_HEIGHT_FOR_DOG = 0.5;

    public static final int DEFAULT_SWIMMING_DISTANCE_FOR_DOG = 10;

    protected String name;
    protected String color;
    protected double jumpHeight;
    protected int distanceRunning;
    protected int age;

    public Animal(String name, String color, int age){
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setJumpHeight(double jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    public void setDistanceRunning(int distanceRunning) {
        this.distanceRunning = distanceRunning;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    public double getJumpHeight() {
        return jumpHeight;
    }

    public int getDistanceRunning() {
        return distanceRunning;
    }

    public abstract void setDistanceSwimming(int distanceSwimming);
    public abstract int getDistanceSwimming();
    public abstract void run(int distance);
    public abstract void jump(double height);
    public abstract void swim(int distance);

}
