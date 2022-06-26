package com.bookstore.pojo;

import java.util.List;

public class IsbnCollectionPojo {
    public List<CollectionOfIsbns> getCollectionOfIsbns() {
        return collectionOfIsbns;
    }

    public void setCollectionOfIsbns(List<CollectionOfIsbns> collectionOfIsbns) {
        this.collectionOfIsbns = collectionOfIsbns;
    }

    private String userId;
    private List<CollectionOfIsbns> collectionOfIsbns;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }



    public static class CollectionOfIsbns {
        private String isbn;

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }
    }
}
