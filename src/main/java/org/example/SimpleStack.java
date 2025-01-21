package org.example;

import java.util.ArrayList;

public class SimpleStack implements Stack {

    private ArrayList<Item> pile;

    public SimpleStack () {
        this.pile = new ArrayList<>();
    }

    /**
     * Tests if this stack is empty
     */
    @Override
    public boolean isEmpty() {
        return pile.isEmpty();
    }

    /**
     * Returns the number of items in this stack.
     */
    @Override
    public int getSize() {
        return this.pile.size();
    }

    /**
     * Pushes an item onto the top of this stack.
     * null item is allowed.
     *
     * @param item an item of the stack
     */
    @Override
    public void push(Item item) {
        this.pile.add(item);
    }

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     */
    @Override
    public Item peek() throws EmptyStackException {
        return this.pile.get(this.pile.size() - 1);
    }

    /**
     * Removes the object at the top of this stack and returns
     * that object as the value of this function.
     *
     * @throws EmptyStackException if this stack is empty.
     */
    @Override
    public Item pop() throws EmptyStackException {
        if (this.pile.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.pile.remove(this.pile.size() - 1);
    }
}
