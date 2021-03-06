package Games.Blackjack.Deck;

/*

    Project     Programming21
    Package     Games.Blackjack.Deck    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2020-11-11

    DESCRIPTION
    
*/

import Games.Blackjack.Blackjack;
import Games.Blackjack.Deck.Card.Card;
import Games.Blackjack.Deck.Card.Face;
import Games.Blackjack.Deck.Card.Suit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * @author Carlos Pomares
 */


public class Deck {

    /*
     * ATTRIBUTES
     * */

    private int cardsOnDeck = 52;
    private ArrayList<Card> deck;
    private Face[] cardFaces;
    private Suit[] cardSuits;
    private Random randomNumber;

    /*
     * METHODS
     * */

    public Deck(){

        // Init Random and set seed by system time.
        this.randomNumber = new Random();
        this.randomNumber.setSeed(System.currentTimeMillis());

        // Initialize deck array.
        this.deck = new ArrayList<Card>(this.cardsOnDeck);

        // Initialize face values.
        this.cardFaces = new Face[]{
                Face.ACE,Face.DEUCE,Face.THREE,
                Face.FOUR,Face.FIVE,Face.SIX,
                Face.SEVEN,Face.EIGHT,Face.NINE,
                Face.TEN,Face.JACK,Face.QUEEN,
                Face.KING
        };

        // Initialize suit values.
        this.cardSuits = new Suit[]{
                Suit.HEARTS,
                Suit.CLUBS,
                Suit.DIAMONDS,
                Suit.SPADES
        };

        // Put cards into deck
        for (int i = 0; i < cardsOnDeck ; i++) {
            deck.add(new Card(cardSuits[i / 13],cardFaces[i % 13]));
        }
    }

    public Card obtainNextCard(){

        /*
            For obtaining the next card on the deck,
            is with getting the card at the top of the deck,
            that means that we have to make some instructions to
            get the first card of the array and putting the others by -1,
            for be the next card.
         */

        // This instruction gets the card at the top before decrementing.
        Card topCard = this.deck.get(0);

        // This loops ensure that the next cards on the deck, update their state to -1, for being
        // the next cards at the future.
        for (int i = 1; i < (this.cardsOnDeck - 1) ; i++) {
            this.deck.set((i - 1), this.deck.get(i));
        }

        // This means, one time you get a card, the number of cards in deck is decremented by 1.
        this.cardsOnDeck--;

        return topCard;
    }

    public void shuffleCards(){
        // Reset the currentCardOnDeck, because the order of the deck is rebuilded.
        Collections.shuffle(this.deck);
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cardsOnDeck=" + cardsOnDeck +
                ", cardFaces=" + Arrays.toString(cardFaces) +
                ", cardSuits=" + Arrays.toString(cardSuits) +
                ", deck=" + deck +
                ", topCard=" + deck.get(0) +
                '}';
    }
}
