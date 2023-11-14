import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println ("*****WELCOME*****");


        boolean gameOver = false;
        double bank = 0;


        while(!gameOver){
            System.out.println("You have $" + bank + " in your bank");
            System.out.println("Please choose one of the following options:");
            System.out.println("(1) Deposit money into the bank");
            System.out.println("(2) Play the game!");
            System.out.println("(3) Quit the game.");
            int choice = input.nextInt();


            if(choice == 1){
                System.out.println("How much would you like to deposit?");
                double deposit = input.nextDouble();
                bank += deposit;
            }
            else if(choice == 3){
                gameOver = true;
                System.out.println("Thanks for playing!");
                System.out.println("You are leaving with $" + bank);
            }
            else{
                System.out.println("How much would you like to bet?");
                double bet = input.nextDouble();
                while(bet > bank){
                    System.out.println("Please enter an amount lower than " + bank);
                    bet = input.nextDouble();
                }
                //user guesses
                System.out.println("What is your guess on the dice roll?");
                int diceGuess = input.nextInt();
                System.out.println("What is your guess on the coin flip, Heads (H) or Tails (T)?");
                String coinGuess = input.next();
                System.out.println("What is your guess on the spinner, red (r), green (g), blue (b), or yellow (y)?");
                String spinGuess = input.next();


                //Create our chance "objects"
                int dice = (int)(Math.random()*6) + 1; //dice will be 1 - 6
                int coin = (int)(Math.random()*2); //0 be heads, and 1 be tails
                int spin = (int)(Math.random()*4); //0 be blue, 1 be red, 2 be green, 3 be yellow


                boolean coinWin = false;
                boolean diceWin = false;
                boolean spinWin = false;
                System.out.print("\n\n");

                System.out.println("You rolled a " + dice);
                if(diceGuess == dice){
                    diceWin = true;
                }

                if(coin == 0){
                    System.out.println("You flipped heads");
                    if(coinGuess.equals("H")){
                        coinWin = true;
                    }
                }
                else {
                    System.out.println("You flipped tails");
                    if(coinGuess.equals("T")){
                        coinWin = true;
                    }
                }


                if(spin == 0){
                    System.out.println("You spun blue");
                    if(spinGuess.equals("b")){
                        spinWin = true;
                    }
                }
                else if(spin == 1){
                    System.out.println("You spun red");
                    if(spinGuess.equals("r")){
                        spinWin = true;
                    }
                }
                else if(spin == 2){
                    System.out.println("You spun green");
                    if(spinGuess.equals("g")){
                        spinWin = true;
                    }
                }
                else {
                    System.out.println("You spun yellow");
                    if(spinGuess.equals("y")){
                        spinWin = true;
                    }
                }


                System.out.println("\n");


                if(coinWin && diceWin && spinWin){
                    System.out.println("CONGRATULATIONS! You guessed all three correctly!");
                    bank += bet * 3;
                }
                else if(coinWin && diceWin){
                    System.out.println("You got the coin and the dice correct.");
                    bank += bet * 2;
                }
                else if(coinWin && spinWin){
                    System.out.println("You got the coin and the spin correct.");
                    bank += bet * 2;
                }
                else if(diceWin && spinWin){
                    System.out.println("You got the dice and the spin correct.");
                    bank += bet * 2;
                }
                else if(diceWin){
                    System.out.println("You only got the dice correct.");
                    bank += bet;
                }
                else if(spinWin){
                    System.out.println("You only got the spin correct.");
                    bank += bet/2;
                }
                else if(coinWin){
                    System.out.println("You only got the coin correct.");
                    bank += bet/4;
                }
                else {
                    System.out.println("Sorry, you somehow managed to get NOTHING correct.");
                    bank -= bet;
                }
            }
            System.out.println("");
        }
    }
}

