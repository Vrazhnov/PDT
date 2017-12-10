package ru.stqa.pft.addressbook.model;

public class GroupData {
    private final String id;
    private final String name;
    private final String footer;
    private final String header;

    public GroupData(String name, String footer, String header) {
        this.id = null;
        this.name = name;
        this.footer = footer;
        this.header = header;
    }

    public GroupData(String id, String name, String footer, String header) {
        this.id = id;
        this.name = name;
        this.footer = footer;
        this.header = header;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        if (id != null ? !id.equals(groupData.id) : groupData.id != null) return false;
        return name != null ? name.equals(groupData.name) : groupData.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFooter() {
        return footer;
    }

    public String getHeader() {
        return header;
    }

}
