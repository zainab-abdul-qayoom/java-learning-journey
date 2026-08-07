package com.practice;

import java.util.Scanner;


class ItemNotFoundException extends Exception{
    public ItemNotFoundException(String message){
        super(message);
    }
}

public class GroceryShopping{
    public static void main(String[] args){




        String[] item = new String[10];
        float[] price = new float[10];

        item[0] = "Mango"; price[0] = 100.0f;
        item[1] = "Apple"; price[1] = 200.0f;
        item[2] = "Milk"; price[2] = 350.0f;
        item[3] = "Bread";  price[3] = 50.0f;
        item[4] = "Noodles"; price[4] = 80.0f;
        item[5] = "Pasta"; price[5] = 700.0f;
        item[6] = "Guava"; price[6] = 450.0f;
        item[7] = "Carrot"; price[7] = 200.0f;
        item[8] = "Tomato"; price[8] = 150.0f;
        item[9] = "Potato"; price[9] = 180.0f;



        Scanner sc = new Scanner(System.in);
        while(true){
            float totalBill = 0.0f;




            while(true){
                try{
                    System.out.print("Enter the item name to add (or type 'finish' for end the shopping ) : ");
                    String inputItem = sc.nextLine();

                    if(inputItem.equalsIgnoreCase("finish")){
                        System.out.println("Your Total Bill is : Rupee " + totalBill);
                        System.out.println("Thank you for shopping with us!");
                        break;
                    }
                    int itemIndex = -1;
                    for(int i = 0; i < item.length; i++){
                        if(item[i].equalsIgnoreCase(inputItem)){
                            itemIndex = i;
                            break;
                        }
                    }

                    if(itemIndex == -1){
                        throw new ItemNotFoundException("Item " + inputItem +  " not found. Please try again");

                    }

                    System.out.print("Enter the quantity of " + item[itemIndex] + " : ");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    float itemCost = price[itemIndex] * quantity;
                    totalBill += itemCost;

                    System.out.println("Added " + quantity + " x " + item[itemIndex] + " to the bill. Current total = Rupee " + totalBill);
                } catch(ItemNotFoundException e){
                    System.out.println(e.getMessage());
                } catch(Exception e){
                    System.out.println("Invalid input. Please try again.");
                    sc.nextLine();
                }

            }

            System.out.println("Type 'exit' to quit the application, or press Enter to start a new cart: ");
            String userInput = sc.nextLine();
            if(userInput.equalsIgnoreCase("exit")){
                System.out.println("Thank you for using the shopping cart. Have a Good Day!");
                break;
            }

        }
        sc.close();
    }
}
