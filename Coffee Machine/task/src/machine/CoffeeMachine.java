package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static final Scanner scan = new Scanner(System.in);
    public static int water = 400;
    public static int money = 550;
    public static int milk = 540;
    public static int coffeeBeans = 120;
    public static int disposableCups = 9;

    public static void main(String[] args) {

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scan.next();
            if (action.equalsIgnoreCase("exit")) {
                break;
            }
            menu(action);
        }
    }

    public static void menu(String action) {

        switch (action.toLowerCase()) {
            case "buy":
                System.out.println("\nWhat do you want to buy? 1 - espresso, " + "2 - latte, 3 - cappuccino, back - to main menu:");
                String coffeeID = scan.next();
                switch (coffeeID) {
                    case "1": //espresso
                        isEnough(250, 0, 16, 4);
                        break;
                    case "2": //latte
                        isEnough(350, 75, 20, 7);
                        break;
                    case "3": //cappuccino
                        isEnough(200, 100, 12, 6);
                        break;
                    case "back":
                        break;
                    default:
                        System.out.println("Not a valid choice");
                        break;
                }
                System.out.println();
                break;
            case "fill":
                fill();
                break;

            case "take":
                take();
                break;
            case "remaining":
                print();
                break;
            case "exit":
                break;
            default:
                System.out.println("Not a valid command");
                break;
        }
    }

    public static void print() {
        System.out.println("\nThe coffee machine has:\n" +
                + water + " of water\n" +
                + milk + " of milk\n" +
                + coffeeBeans + " of coffee beans\n" +
                + disposableCups + " of disposable cups\n" +
                + money + " of money");
        System.out.println();
    }

    public static void fill() {
        System.out.println("\nWrite how many ml of water do you want to add:");
        water += scan.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += scan.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        coffeeBeans += scan.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        disposableCups += scan.nextInt();
        System.out.println();
    }

    public static void take() {
        System.out.println("\nI gave you $" + money);
        money = 0;
        System.out.println();
    }

    public static void isEnough(int requiredWater, int requiredMilk, int requiredCoffee, int requiredMoney) {
        if (water - requiredWater < 0) {
            System.out.println("Sorry, not enough water");
        } else if (milk - requiredMilk < 0) {
            System.out.println("Sorry not enough milk");
        } else if (coffeeBeans - requiredCoffee < 0) {
            System.out.println("Sorry, not enough coffee");
        } else if (disposableCups <= 0) {
            System.out.println("Sorry, not enough cups");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            water -= requiredWater;
            milk -= requiredMilk;
            coffeeBeans -= requiredCoffee;
            disposableCups--;
            money += requiredMoney;
        }
    }

}