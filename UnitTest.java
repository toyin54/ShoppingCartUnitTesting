import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnitTest {

    @Test
    public void testCartZero(){
        ShoppingCart cart = new ShoppingCart();
        assertEquals(cart.getItemCount(),0);
    }

    @Test
    public void testCartZeroWhenEmpty(){
        ShoppingCart cart = new ShoppingCart();
        Product item = new Product("Mop" , 12.0);
        cart.addItem(item);
        cart.empty();
        assertEquals(cart.getItemCount(),0);
    }

    @Test
    public void testCartAddedItem(){
        ShoppingCart cart = new ShoppingCart();
        Product item = new Product("Mop" , 12.0);
        assertEquals(cart.getItemCount(),0);
        cart.addItem(item);
        assertEquals(cart.getItemCount(),1);
    }

    @Test
    public void testCartMultipleItems(){
        ShoppingCart cart = new ShoppingCart();
        Product item = new Product("Mop" , 12.0);
        Product item1 = new Product("Laptop" , 12.0);
        assertEquals(cart.getItemCount(),0);
        cart.addItem(item);
        cart.addItem(item1);
        assertEquals(cart.getItemCount(),2);
        Exception exp = new ProductNotFoundException();
        try {
            cart.removeItem(item1);
        } catch (Exception e){
            assertEquals(exp,e);
        }
        assertEquals(cart.getItemCount(),1);
    }

}
