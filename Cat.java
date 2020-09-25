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
        System.out.println("Коты не умеют плавать!!!");
    }
}
