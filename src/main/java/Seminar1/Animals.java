package Seminar1;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Animals implements Serializable {
    private final List<Food> listFood ;
    private final TypesAnimals type;
    private final String name;
    private final int age;
    public Animals(TypesAnimals type, String name, int age, List<Food> listFood){
        this.type=type;
        this.name=name;
        this.age=age;
        this.listFood=listFood;
    }

    public int getAge() {
        return age;
    }

    public List<Food> getFoodList() {
        return listFood;
    }

    public String getName() {
        return name;
    }

    public TypesAnimals getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Animals{" +
                "name = '" + name + '\'' +
                ", type = " + type +
                ", age = " + age +
                ", listfood=" +listFood +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,type,age,listFood);
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animals animal = (Animals) o;
        return age == animal.age &&
                Objects.equals(name, animal.name) &&
                type == animal.type &&
                Objects.equals(listFood, animal.listFood);
    }
}