package fr.unice.polytech.polynews.tutoriel;

/**
 * Created by Antoine on 19/03/2016.
 */
public class News {
    private int id;
    private String title;
    private String content;
    private String author;
    private String date;
    private int category;
    private int media_type;
    private String media_path;


    public News(int id, String title, String content, String date, String author, int category, int media_type, String media_path) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.author = author;
        this.category = category;
        this.media_type = media_type;
        this.media_path = media_path;
    }

    public News() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date.substring(0,10);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCategory() {
        return category;
    }

    public String getCategoryString() {
        if(category==1)
            return "POLITIQUE";
        else
            return "SOCIETE";
    }


    public void setCategory(int category) {
        this.category = category;
    }

    public int getMedia_type() {
        return media_type;
    }

    public void setMedia_type(int media_type) {
        this.media_type = media_type;
    }

    public String getMedia_path() {
        return media_path;
    }

    public void setMedia_path(String media_path) {
        this.media_path = media_path;
    }
}
