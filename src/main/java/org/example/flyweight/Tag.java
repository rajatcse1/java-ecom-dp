package org.example.flyweight;

public class Tag {
    private final TagType tagType;

    public Tag(TagType tagTypeArgs) {
        tagType = tagTypeArgs;
    }

    public String getTag() {
        return tagType.name();
    }
}
