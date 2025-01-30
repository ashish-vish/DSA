package com.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

/*
How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?
 */
public class TestNote {

    public static void main(String[] args) {
        List<Notes> noteLst = new ArrayList<>();
        noteLst.add(new Notes(1, "note1", 11));
        noteLst.add(new Notes(2, "note2", 22));
        noteLst.add(new Notes(3, "note3", 33));
        noteLst.add(new Notes(4, "note4", 44));
        noteLst.add(new Notes(5, "note5", 55));
        noteLst.add(new Notes(6, "note4", 66));

        LinkedHashMap<String, Integer> collect = noteLst.stream()
                .sorted(Comparator.comparingInt(Notes::getTagId)
                        .reversed())
                .collect(Collectors.toMap(
                        Notes::getName,
                        Notes::getTagId,
                        (n1, n2) -> n2,
                        LinkedHashMap::new
                ));
        System.out.println(collect);
    }



    static class Notes {
        int id;
        String name;
        int tagId;

        public Notes(int id, String name, int tagId) {
            this.id = id;
            this.name = name;
            this.tagId = tagId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getTagId() {
            return tagId;
        }

        public void setTagId(int tagId) {
            this.tagId = tagId;
        }

        @Override
        public String toString() {
            return "Notes{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", tagId=" + tagId +
                    '}';
        }
    }
}
