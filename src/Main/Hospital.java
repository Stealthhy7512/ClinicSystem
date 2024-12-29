package Main;

import java.util.LinkedList;
import java.io.Serializable;

public class Hospital implements Serializable {
    private final int id;
    private String name;
    private LinkedList<Section> sectionLinkedList;

    public Hospital(int id, String name) {
        this.id = id;
        this.name = name;
        sectionLinkedList = new LinkedList<>();
    }

    public Section getSection(int id) {
        if (sectionLinkedList != null) {
            for (Section sect : sectionLinkedList) {
                if (sect.getId() == id) {
                    return sect;
                }
            }
        }
        return null;
    }

    public Section getSection(String name) {
        if (sectionLinkedList != null) {
            for (Section sect : sectionLinkedList) {
                if (sect.getName().equals(name)) {
                    return sect;
                }
            }
        }
        return null;
    }

    public synchronized void addSection(Section section) throws DuplicateInfoException {
        if (sectionLinkedList != null) {
            for (Section sect : sectionLinkedList) {
                if(sect.getId() == section.getId()) {
                    throw new DuplicateInfoException("Section with ID {" + section.getId() + "} already exists");
                }
            }
        }
        sectionLinkedList.add(section);
    }

    public void listSections() {
        if (sectionLinkedList != null) {
            System.out.println("Sections");
            System.out.println("****************");
            for (Section section : sectionLinkedList) {
                System.out.println(section);
            }
        }
        System.out.println("****************");
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() { return name; }

    public LinkedList<Section> getSectionLinkedList() {
        return sectionLinkedList;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Name: " + name;
    }
}
