package com.abc.board.model.dto;

public class BoardDTO {
    private Integer boardId;
    private String name;
    private String description;
    private Boolean userActive;
    private Boolean adminActive;
    public BoardDTO(){}

    public BoardDTO(Integer boardId, String name, String description, Boolean userActive, Boolean adminActive) {
        this.boardId = boardId;
        this.name = name;
        this.description = description;
        this.userActive = userActive;
        this.adminActive = adminActive;
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
        return userActive;
    }

    public void setUserActive(Boolean userActive) {
        this.userActive = userActive;
    }

    public Boolean getAdminActive() {
        return adminActive;
    }

    public void setAdminActive(Boolean adminActive) {
        this.adminActive = adminActive;
    }
}
