package com.example.sportlink.ui.dashboard;

public class InterestTag {
    private String name;
    private int icon;

    public InterestTag(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public int getIcon() {
        return icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
