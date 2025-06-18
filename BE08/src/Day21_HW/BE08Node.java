package Day21_HW;

import java.util.ArrayList;

public class BE08Node {
    Integer value;
    ArrayList<BE08Node> children;

    public BE08Node(Integer value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void addChild(BE08Node child) {
        this.children.add(child);
    }
}