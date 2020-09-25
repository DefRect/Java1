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
    public void run(int distance) {
        if(this.distanceRunning >= distance){
            System.out.println(this.name + " может пробежать " + distance + "м");
        } else{
            System.out.println(this.name + " не может пробежать " + distance + "м");
        }
    }

    @Override
    public void jump(double height) {
        if(this.jumpHeight >= height){
            System.out.println(this.name + " может прыгнуть на " + height + "м");
        } else{
            System.out.println(this.name + " не может прыгнуть на " + height + "м");
        }
    }

    @Override
    public void swim(int distance) {
        if(this.distanceSwimming >= distance){
            System.out.println(this.name + " может проплыть " + distance + "м");
        } else{
            System.out.println(this.name + " не может проплыть " + distance + "м");
        }
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
