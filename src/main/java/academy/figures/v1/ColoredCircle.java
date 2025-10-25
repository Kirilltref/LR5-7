package main.java.academy.figures.v1;

import java.util.Objects;

public class ColoredCircle {
    private Point center;  // Центр круга
    private int radius;    // Радиус
    private int color;     // Цвет

    // Конструктор с точкой центра
    public ColoredCircle(Point center, int radius, int color) {
        this.center = new Point(center.getX(), center.getY());
        this.radius = radius;
        this.color = color;
    }

    // Конструктор с координатами центра
    public ColoredCircle(int xCenter, int yCenter, int radius, int color) {
        this.center = new Point(xCenter, yCenter);
        this.radius = radius;
        this.color = color;
    }

    // Конструктор с радиусом и цветом
    public ColoredCircle(int radius, int color) {
        this.center = new Point(0, 0);
        this.radius = radius;
        this.color = color;
    }

    // Конструктор с цветом
    public ColoredCircle(int color) {
        this.center = new Point(0, 0);
        this.radius = 1;
        this.color = color;
    }

    // Конструктор по умолчанию
    public ColoredCircle() {
        this.center = new Point(0, 0);
        this.radius = 1;
        this.color = 1;
    }

    // Получение центра (возвращаем копию)
    public Point getCenter() {
        return new Point(center.getX(), center.getY());
    }

    // Получение радиуса
    public int getRadius() {
        return radius;
    }

    // Установка центра (создаем копию)
    public void setCenter(Point center) {
        this.center = new Point(center.getX(), center.getY());
    }

    // Установка радиуса
    public void setRadius(int radius) {
        this.radius = radius;
    }

    // Получение цвета
    public int getColor() {
        return color;
    }

    // Установка цвета
    public void setColor(int color) {
        this.color = color;
    }

    // Перемещение круга
    public void moveRel(int dx, int dy) {
        center.setX(center.getX() + dx);
        center.setY(center.getY() + dy);
    }
    public void moveTo(int x, int y) {
        int dx = x - center.getX();
        int dy = y - center.getY();
        moveRel(dx, dy);
    }

    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }
    // Изменение размера радиуса
    public void resize(double ratio) {
        this.radius = (int)(radius * ratio);
    }

    // Вычисление площади
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Вычисление периметра (длина окружности)
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    // Проверка, лежит ли точка внутри (включая границу)
    public boolean isInside(int x, int y) {
        long dx = (long)x - center.getX();
        long dy = (long)y - center.getY();
        long distSquared = dx * dx + dy * dy;
        long radiusSquared = (long)radius * radius;
        return distSquared <= radiusSquared;
    }

    // Проверка точки типа Point
    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    // Автогенерированный equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColoredCircle that = (ColoredCircle) o;
        return radius == that.radius &&
                color == that.color &&
                center.equals(that.center);
    }

    // Автогенерированный hashCode
    @Override
    public int hashCode() {
        return Objects.hash(center, radius, color);
    }
}
