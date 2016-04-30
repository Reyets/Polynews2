package fr.unice.polytech.polynews.association;

/**
 * Created by tibo on 18/04/16.
 */
public class Assos {
    private int id;
    private String name;
    private String description;
    private String image;

    public Assos(int id,String name, String description,String image){
        this.id=id;
        this.name=name;
        this.description=description;
        this.image=image;
    }

    public Assos(){}

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return  description;
    }

    public void setId(int id){
        this.id=id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getImage(){return image;}

    public void setImage(String image){this.image = image;}
}
