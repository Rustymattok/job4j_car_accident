package di;

/**
 * Concle for DI
 */
public class ConcoleInput {

    public void show(StartUI st){
        System.out.println("Test show() method");
        System.out.println("All parameters: ");
        st.print();
    }
}
