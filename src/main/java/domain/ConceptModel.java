package domain;




public class ConceptModel {

    private int id;
    private String content;

    public ConceptModel() {
    }

    public ConceptModel(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id").append(" : ").append(this.id).append(", ");
        stringBuilder.append("content").append(" : ").append(this.content);

        return stringBuilder.toString();
    }

}