public class Sports {

    private int id=0;
    private String name;
    private String desc;

    public Sports(){
        setName("");
        setDesc("");
    }

    public Sports(String name, String desc){
        setName(name);
        setDesc(desc);
    }

    public void setName(String title) {
        this.name = title;
    }
    public String getName() {
        return name;
    }
    public void setDesc(String director) {
        this.desc = director;
    }
    public String getDesc() {
        return desc;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
}
