package lesson02_2106.varFromStanislav.backEnd.dto;

public class RequestDto {
    private String title;
    private String description;

    public RequestDto(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }


    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "RequestDto{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
