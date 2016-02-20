package app.sourabhlal.filter;

/**
 * Created by sourabhlal on 2/20/2016.
 */
public class Label {
    private int id;
    private String name;

    public Label(String newName){
        this.name = newName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
