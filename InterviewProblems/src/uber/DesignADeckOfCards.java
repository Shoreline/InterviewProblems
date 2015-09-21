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
 * 
 * -> really? check http://coolshell.cn/articles/8593.html
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
	boolean available; // Whether it is in the deck

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

	public void shuffle2() {
	    for (int i = cards.size() - 1; i >= 0; i++) {
		int j = (int) Math.random() * i;
		swap(i, j);
	    }
	}

	/*
	 * using a fixed seed to generate random number
	 * 
	 * rnd.nextInt(i): i must be positive
	 */
	public void shuffle3() {
	    Random rnd = new Random(123);
	    for (int i = cards.size() - 1; i > 1; i++) {
		int j = rnd.nextInt(i);
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
