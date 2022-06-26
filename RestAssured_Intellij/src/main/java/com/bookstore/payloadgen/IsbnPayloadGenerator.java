package com.bookstore.payloadgen;

import com.bookstore.pojo.IsbnCollectionPojo;
import com.bookstore.utils.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IsbnPayloadGenerator {

    private static final String fileName = "isbn";
    public static IsbnCollectionPojo getIsbnData() throws IOException {
        IsbnCollectionPojo ii = new IsbnCollectionPojo();
        ii.setUserId((String)JsonParser.readJsonFile(fileName, "instructor"));
        List<IsbnCollectionPojo.CollectionOfIsbns> isb = new ArrayList<IsbnCollectionPojo.CollectionOfIsbns>();
        IsbnCollectionPojo.CollectionOfIsbns i1 = new IsbnCollectionPojo.CollectionOfIsbns();
        i1.setIsbn((String)JsonParser.readJsonFile(fileName, "isbn"));
        isb.add(i1);
        ii.setCollectionOfIsbns(isb);
        return ii;
    }
}
