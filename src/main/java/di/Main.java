package di;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.reg(Store.class);
        context.reg(StartUI.class);
        context.reg(ConcoleInput.class);
        StartUI ui = context.get(StartUI.class);
        ConcoleInput cn = context.get(ConcoleInput.class);
        ui.add("Petr Arsentev");
        ui.add("Ivan ivanov");
        cn.show(ui);
//        ui.print();
    }
}