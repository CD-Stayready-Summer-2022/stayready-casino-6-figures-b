package com.stayready.games;
import com.stayready.Player;
import com.stayready.cards.*;
import java.util.concurrent.TimeUnit;
import java.util.*;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class GoFish extends CardGame {
    private final static Integer NUMBER_TO_DEAL = 7;
    private Player player1;
    private Player player2;
    private Scanner scanner;
    private static Integer moves = 0;

    public GoFish(Player player1, Player player2) {
        this.player1 =  player1;
        this.player2 =  player2;
        this.scanner = new Scanner(System.in);
    }
    @Override
    public void startGame() {
        deal();
        while ((player1.getBookNum() + player2.getBookNum() <= 13)  && deck.cardsRemaining() != 0) {
            if(player1.getHand().getCards().size() != 0  && deck.cardsRemaining() != 0){
                promptUserToPlay(player1, player2);
            }
            if(player2.getHand().getNumberOfCards() != 0 && deck.cardsRemaining() != 0){
                promptComputerToPlay(player2, player1, true, false);
            }
        }
        if(player1.getBookNum() > player2.getBookNum()){
            System.out.println(String.format("\n%s has won the game!", player1.getName()));
        }else if(player2.getBookNum() > player2.getBookNum()){
            System.out.println(String.format("\n%s has won the game!", player2.getName()));
        }else{
            System.out.println(String.format("\nIt's a TIE!"));
        }
        System.out.println(String.format("Moves %d", getMoves()));
    }

    public void botStartGame() {
        deal();
        while ((player1.getBookNum() + player2.getBookNum() <= 13)  && deck.cardsRemaining() != 0) {
            if(player1.getHand().getCards().size() != 0  && deck.cardsRemaining() != 0){
                promptComputerToPlay(player1, player2, true, true);
            }
            if(player2.getHand().getNumberOfCards() != 0 && deck.cardsRemaining() != 0){
                promptComputerToPlay(player2, player1, false, true);
            }
        }
        if(player1.getBookNum() > player2.getBookNum()){
            System.out.println(String.format("\n%s has won the game!", player1.getName()));
        }else if(player2.getBookNum() > player2.getBookNum()){
            System.out.println(String.format("\n%s has won the game!", player2.getName()));
        }else{
            System.out.println(String.format("\nIt's a TIE!"));
        }
        if(deck.cardsRemaining() == 0 ){
            System.out.println("The pond was emptied!");
        }
        System.out.println(String.format("Moves %d", getMoves()));
    }

    public void promptUserToPlay(Player player, Player opponent) {
        moves++;
        Hand hand1 = (player1.equals(player)) ? player1.getHand() : player2.getHand();
        Hand hand2 = (player1.equals(player)) ? player2.getHand() : player1.getHand();

        System.out.println(String.format("/n---------------- %s's Turn ----------------", player.getName()));
        System.out.println(String.format("%s's Number of Books: %d", player.getName(), player.getBookNum()));
        while(player.getHand().getNumberOfCards() == 0 && deck.cardsRemaining() !=0 ){
            Card tempCard = deck.takeCardFromDeck();
            hand1.giveCardToHand(tempCard);
            System.out.println(String.format("\n* %s has no cards.\n *", player.getName()));
            System.out.println(String.format("*%s draws a card from the pond ♥️♣️♦️♠️ 🎣 💧*", player.getName()));
            //method for checking 4ofkind
            if(bookManager(player, tempCard.getValue())) {
                System.out.println(String.format(" * %s just made got a full book of %s!* ", player.getName(), tempCard.getValue().name));
            }
        }
        if(deck.cardsRemaining() != 0 ) {
            //Storing the qty of unique cards in the hand of the player separately
            HashMap<CardValue, String> options = new HashMap<>();
            ArrayList<CardValue> valuesInHand = new ArrayList<>();
            for (Card card : player.getHand().getCards()) {
                if (!options.containsKey(card.getValue())) {
                    options.put(card.getValue(), card.getValue().name);
                    valuesInHand.add(card.getValue());
                }
            }

            //Menu displaying cards player can play prompting player for which cards to ask for
            System.out.println("Option\t\tCard Type\tQty in Hand");
            int i = 0;
            for (CardValue val : valuesInHand) {
                System.out.print(String.format("Press %d for %s", i++, val.name));
                if (val.getName().length() <= 3) {
                    System.out.println(String.format("\t\t\t%d", hand1.getNumberOfCardsWithSpecificValue(val)));
                } else {
                    System.out.println(String.format("\t\t%d", hand1.getNumberOfCardsWithSpecificValue(val)));
                }
            }

            //Managing input of player
            System.out.println("Enter your choice now: ");
            String input = scanner.next();
            Integer number = 0;
            try {
                number = Integer.valueOf(input);
            } catch (NumberFormatException ne) {
                System.out.println("Choose only from the options above!");
                System.out.println("Emter your choice now: ");
            }
            CardValue choice = valuesInHand.get((int) number);

            System.out.println(String.format("%s: Do you have any %s cards?", player.getName(), choice.getName()));

            //For OPPONENT'S cards
            //Storing the qty of unique cards in the hand of the opponent separately
            HashMap<CardValue, String> options2 = new HashMap<>();
            for (Card card : hand2.getCards()) {
                if (!options2.containsKey(card.getValue())) {
                    options2.put(card.getValue(), card.getValue().name);
                    valuesInHand.add(card.getValue());
                }
            }

            //Checking card choice of player with his opponents hand to see if opponents hand contains that card
            if (options2.containsKey(choice)) {
                //removing cards with that value from the user's hands
                List<Card> removed = new ArrayList<Card>();
                for (Card element : hand2.getCards()) {
                    if (element.getValue() == choice) {
                        removed.add(element);
                        hand1.giveCardToHand(element);
                    }
                }
                hand2.getCards().removeAll(removed);
                System.out.println(String.format("%s: I have %d %s cards", opponent.getName(), removed.size(), choice.name));
                System.out.println(String.format("%s has received %d %s card(s) from %s.\n", player.getName(), removed.size(), choice.name, opponent.getName()));
                bookManager(player, choice);

                if (hand2.getNumberOfCards() != 0 && deck.cardsRemaining() != 0) {
                    hand2.giveCardToHand(deck.takeCardFromDeck());
                    promptUserToPlay(player, opponent);
                }

            } else {
                System.out.println(String.format("%s: No I do not, 🐟🐠 GO FISH!!! 🐟🐠\n", opponent.getName()));
                System.out.println(String.format("*%s draws a card from the pond ♥️♣️♦️♠️ 🎣 💧*", player.getName()));
                //Player draws card for guessing incorrectly
                Card tempCard = deck.takeCardFromDeck();
                hand1.giveCardToHand(tempCard);
                //method for checking 4ofkind
                if (bookManager(player, choice)) {
                    System.out.println(String.format("* %s just made got a full book of %ss!* ", player.getName(), tempCard.getValue().name));
                }
            }
        }
    }

    public void promptComputerToPlay(Player player, Player opponent, boolean hardMode, boolean fastMode) {
        moves++;
        Random rand = new Random();
        Hand hand1 = (player1.equals(player)) ? player1.getHand() : player2.getHand();
        Hand hand2 = (player1.equals(player)) ? player2.getHand() : player1.getHand();
        if(!fastMode){thinkingTime(750);}
        System.out.println(String.format("---------------- %s's Turn ----------------", player.getName()));
        if(!fastMode){thinkingTime(150);}
        System.out.println(String.format("%s's Number of Books: %d", player.getName(), player.getBookNum()));
        if(!fastMode){thinkingTime(750);}
        if(player.getHand().getNumberOfCards() == 0){

            System.out.println(String.format("\n\t%s has no cards. %s draws a card.\n", player.getName(), player.getName()));
        }
        //Storing the qty of unique cards in the hand of the player separately
        HashMap<CardValue, String> options = new HashMap<>();
        ArrayList<CardValue> valuesInHand = new ArrayList<>();
        for (Card card : player.getHand().getCards()) {
            if (!options.containsKey(card.getValue())) {
                options.put(card.getValue(), card.getValue().name);
                valuesInHand.add(card.getValue());
            }
        }

        //Menu displaying cards player can play
        System.out.println(String.format("\t\t\t\tCards\n"));
        if(!fastMode){thinkingTime(500);}
        System.out.println("\t\t\t\tCard Type\tQty in Hand");
        int i = 0;
        for (CardValue val : valuesInHand) {
            if(!fastMode){thinkingTime(200);}
            System.out.print(String.format("\t\t\t\t%s", val.name));
            if(val.getName().length() <= 3){
                System.out.println(String.format("\t\t\t%d", hand1.getNumberOfCardsWithSpecificValue(val)));
            }else{
                System.out.println(String.format("\t\t%d", hand1.getNumberOfCardsWithSpecificValue(val)));
            }
        }

        //For OPPONENT'S cards
        //Storing the qty of unique cards in the hand of the opponent seperately
        HashMap<CardValue, String> options2 = new HashMap<>();
        ArrayList<CardValue> valuesInHand2 = new ArrayList<>();
        for (Card card : hand2.getCards()) {
            if (!options2.containsKey(card.getValue())) {
                options2.put(card.getValue(), card.getValue().name);
                valuesInHand2.add(card.getValue());
            }
        }

        //Logic of deciding choice
        CardValue choice;
        if(hardMode){
            List<CardValue>validOptions = new ArrayList<>();
            for(CardValue each: valuesInHand){
                for(CardValue opponentEach: valuesInHand2){
                    if(each.id == opponentEach.id){
                        validOptions.add(each);
                    }
                }
            }
            if(validOptions.size() == 0){
                choice = valuesInHand.get(rand.nextInt(valuesInHand.size()));
            }else{
                choice = validOptions.get(rand.nextInt(validOptions.size()));
            }
        }else{
            choice = valuesInHand.get(rand.nextInt(valuesInHand.size()));
        }

        //thinking ANIMATION
        System.out.print(String.format("\n\n%s is thinking ", player.getName()));
        for(int x = 0; x < 5; x++){
            if(!fastMode){thinkingTime(750);}
            System.out.print(" .");
        }
        System.out.println();

        //MESSAGE ASKING OTHER USER FOR A CARD
        if(!fastMode){thinkingTime(1750);}
        System.out.println(String.format("%s: Do you have any %s cards?", player.getName(), choice.getName()));

        //Checking card choice of player with his opponents hand to see if opponents hand contains that card
        if (options2.containsKey(choice)) {
            //removing cards with that value from the user's hands
            List<Card> removed = new ArrayList<Card>();
            for (Card element : hand2.getCards()) {
                if (element.getValue() == choice){
                    removed.add(element);
                    hand1.giveCardToHand(element);
                }
            }
            hand2.getCards().removeAll(removed);
            if(!fastMode){thinkingTime(1750);}
            System.out.println(String.format("%s: I have %d %s cards", opponent.getName(), removed.size(), choice.name));
            if(!fastMode){thinkingTime(1000);}
            System.out.println(String.format("%s has received %d %s card(s) from %s.\n",player.getName(), removed.size(), choice.name, opponent.getName()));
            //method for checking 4ofkind
            if(bookManager(player, choice)){
                if(!fastMode){thinkingTime(1750);}
                System.out.println(String.format(" * %s just made got a full book of %ss!* ", player.getName(), choice.name));
            }

            if(hand2.getNumberOfCards() != 0 && deck.cardsRemaining() !=0){
                hand2.giveCardToHand(deck.takeCardFromDeck());
                promptComputerToPlay(player, opponent, hardMode, fastMode);
            }
        }
        else{
            if(!fastMode){thinkingTime(1750);}
            System.out.println(String.format("%s: No I do not, 🐟🐠 GO FISH!!! 🐟🐠", opponent.getName()));
            if(!fastMode){thinkingTime(1750);}
            System.out.println(String.format("* %s draws a card from the pond ♥️♣️♦️♠️ 🎣 💧 *\n", player.getName()));
            //Player draws card for guessing incorrectly
            Card tempCard = deck.takeCardFromDeck();
            hand1.giveCardToHand(tempCard);
            //method for checking 4ofkind
            if(bookManager(player, tempCard.getValue())){
                if(!fastMode){thinkingTime(1750);}
                System.out.println(String.format(" * %s just made got a full book of %s!* ", player.getName(), tempCard.getValue().name));
            }
        }
    }

    public Boolean bookManager(Player player, CardValue choice){
        if (player.getHand().isThereABook(choice)) {
            player.getHand().removeBook(choice);
            player.setBookNum(player.getBookNum() + 1);
            return true;
        }
        return false;
    }

    public void deal(){
        for(int x =0 ; x < NUMBER_TO_DEAL +1; x++){
            Card card1 = deck.takeCardFromDeck();
            player1.getHand().giveCardToHand(card1);
            bookManager(player1, card1.getValue());

            Card card2 = deck.takeCardFromDeck();
            player2.getHand().giveCardToHand(card2);
            bookManager(player2, card2.getValue());
        }
    }

    public static Integer getMoves() {
        return moves;
    }

    public void thinkingTime(int time){
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}