package com.loser.dto;

public class View {

    public interface UserSimpleView{}
    public interface UserDetailView extends UserSimpleView{}

    public interface BlogSimpleView extends UserSimpleView{}
    public interface BlogDetailView extends BlogSimpleView{}
}
