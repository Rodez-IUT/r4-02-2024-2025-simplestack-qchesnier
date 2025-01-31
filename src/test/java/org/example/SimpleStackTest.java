package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test behaviour of a SimpleStack")
class SimpleStackTest {

    private Stack stack;
    private Item item;

    @BeforeEach
    public void initializeStack() {
        // Given an empty stack and an item
        stack = new SimpleStack();
        item = new SimpleItem();
    }

    @Test
    @DisplayName("Test the state of a newly created stack")
    public void testCreateEmptyStack() { // Test case

        // Then… (oracle)
        assertTrue(stack.isEmpty(), "A new stack must be empty");
        assertEquals( 0, stack.getSize(), "A new stack has no element");
    }

    @Test
    @DisplayName("Test the push of items")
    public void testPush() throws EmptyStackException {

        // When the item is pushed in the stack
        stack.push(item);

        // Then…
        assertFalse(stack.isEmpty(), "The stack must not be empty");
        assertEquals(1, stack.getSize(),"The stack must constain 1 item");
        assertSame( item, stack.peek(),"The pushed item must be is on top of the stack");

        // Given a new item to add
        Item item2 = new SimpleItem();

        // When we add the new item
        stack.push(item2);

        // then...
        assertFalse(stack.isEmpty(), "The stack must be not empty");
        assertEquals(2, stack.getSize(),"The stack must constain 2 items");
        assertSame( item2, stack.peek(),"The pushed item must be on top of the stack");
    }

    @Test
    @DisplayName("Test the peek of the stack")
    public void testPeek() throws EmptyStackException {
        // Given a stack with 2 items
        Item object1 = new SimpleItem();
        Item object2 = new SimpleItem();
        stack.push(object1);
        stack.push(object2);

        // When take the peek of the stack, must return the item on the top of the stack
        assertEquals(stack.peek(), object2, "The item return is on the top of the stack");
    }

    @Test
    @DisplayName("Test the peek of the stack")
    public void testPeekOnEmptyStack() throws EmptyStackException {
        // When take the peek of the stack, must throw an EmptyStackException.
        assertThrows(EmptyStackException.class, ()->stack.peek(), "EmptyStackException not thrown");
    }

    @Test
    @DisplayName("Test limit when trying to pop an empty stack")
    public void testPopOnEmptyStack()  {
        // When we "pop" the stack, should throw an EmptyStackException.
        assertThrows(EmptyStackException.class, ()->stack.pop(), "EmptyStackException not thrown");
        assertThrows(EmptyStackException.class, stack::pop, "EmptyStackException not thrown");
    }

    @Test
    @DisplayName("Test limit when trying to pop a stack")
    public void testPopOnStack() throws EmptyStackException {
        // Given a stack with 2 items
        stack.push(item);

        // When we "pop" the stack, the stack should have a size equal to 1.
        Item itemPop = stack.pop();

        // Then the stack should have a size equal to 1.
        assertTrue(stack.isEmpty(), "Stack not empty.");
        // And the item pop is the one which got pop
        assertEquals(item, itemPop, "object not throw.");
    }
}