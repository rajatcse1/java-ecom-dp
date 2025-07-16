package org.example.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightTagFactory {
    private Map<TagType, Tag> createdTag = new HashMap<>();

    public Tag getTag(TagType tagType) {
        if (!createdTag.containsKey(tagType)) {
            System.out.println(String.format("new tag created: %s", tagType.name()));
            createdTag.put(tagType, new Tag(tagType));
        }
        return createdTag.get(tagType);
    }

}
