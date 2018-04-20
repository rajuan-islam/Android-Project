package com.fahim.defensemechanism;

public class Container {
    public boolean hasOrigin;
    public int nameId, originId, bigPicId, smallPicId, descriptionId;

    public Container(boolean ho, int name, int origin, int big, int small, int description){
        hasOrigin = ho;
        nameId = name;
        originId = origin;
        bigPicId = big;
        smallPicId = small;
        descriptionId = description;
    }
}
