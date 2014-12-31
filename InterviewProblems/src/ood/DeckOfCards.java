package ood;

import java.util.ArrayList;

/*
 * All data fields are protected or private; only some methods are public
 */

public class DeckOfCards {

    public enum Suit {
	Diamond(0), Club(1), Heart(2), Spade(3);
	private int value;

	private Suit(int v) {
	    value = v;
	}

	public int getValue() {
	    return value;
	}

	public static Suit getSuitFromValue(int i) {
	    // is this right?
	    if (i == 0)
		return Diamond;
	    if (i == 1)
		return Club;
	    if (i == 2)
		return Heart;
	    if (i == 3)
		return Spade;
	    return null;
	}
    }

    public abstract class Card {
	private boolean available = true; // private? then it cannot be
					  // inherited by sub classes
	protected int faceValue;
	protected Suit suit;

	public Card(int v, Suit s) {
	    faceValue = v;
	    suit = s;
	}

	public abstract int value();

	public Suit getSuit() {
	    return suit;
	}

	public boolean isAvailable() {
	    return available;
	}

	public void makeAvailable() {
	    available = true;
	}

	public void makeUnavailable() {
	    available = false;
	}

    }

    public class Deck<T extends Card> {
	private ArrayList<T> cards;
	private int firstAvailable = 0;

	public void setDeckOfCards(ArrayList<T> deckOfCards) {

	}

	public void shuffle() {
	}

	public int remainingCards() {
	    return cards.size() - firstAvailable;
	}

	/*
	 * how to create a generic array? *
	 */
	@SuppressWarnings("unchecked")
	public T[] dealHand(int number) {
	    // T[] hand = new T[number]; Not allowed to directly "new" a generic
	    // array!

	    return (T[]) cards.subList(0, number).toArray();
	}

	public T dealCard() {
	    return cards.get(0); // maybe wrong
	}
    }
}
