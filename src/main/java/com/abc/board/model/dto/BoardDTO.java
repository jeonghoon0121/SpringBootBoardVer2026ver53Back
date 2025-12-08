package com.abc.board.model.dto;

public class BoardDTO {
    private Integer boardId;
    private String name;
    private String description;
    private Boolean UserActive;
    private Boolean AdminActive;
    public BoardDTO(){}

    public BoardDTO(Integer boardId, String name, String description, Boolean userActive, Boolean adminActive) {
        this.boardId = boardId;
        this.name = name;
        this.description = description;
        UserActive = userActive;
        AdminActive = adminActive;
    }

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getUserActive() {
        return UserActive;
    }

    public void setUserActive(Boolean userActive) {
        UserActive = userActive;
    }

    public Boolean getAdminActive() {
        return AdminActive;
    }

    public void setAdminActive(Boolean adminActive) {
        AdminActive = adminActive;
    }
}
