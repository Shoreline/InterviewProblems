package uber;

import java.util.*;

/**
 * Represent a deck of playing cards in an object-oriented design.
 * 
 * (1) Write a function to output the deck.
 * 
 * (2) Write a fn to shuffle the deck.
 *
 */

/*
 * the shuffle is done by randomly swap the i-th and j-th cards.
 * 
 * -> each card get a chance to swap its position with another ramdonly selected
 * card (can be itself)
 */
public class DesignADeckOfCards {
    public enum Suit {
	Club(0), Diamond(1), Heart(2), Spade(3);
	int value;

	Suit(int v) {
	    value = v;
	}
    }

    public class Card {
	Suit suit;
	int value;

	@Override
	public String toString() {
	    return "suit:" + suit.value + ", value:" + value;
	}
    }

    public class Deck {
	List<Card> cards;

	private void swap(int i, int j) {
	    Card tmp = cards.get(i);
	    cards.set(i, cards.get(j));
	    cards.set(j, tmp);
	}

	public void shuffle() {
	    for (int i = 0; i < cards.size(); i++) {
		int j = (int) Math.random() * cards.size();
		swap(i, j);
	    }
	}

	public String output() {
	    StringBuilder res = new StringBuilder();

	    for (int i = 0; i < cards.size(); i++) {
		res.append(i + "=" + cards.get(i).toString());
	    }

	    return res.toString();
	}
    }
}
