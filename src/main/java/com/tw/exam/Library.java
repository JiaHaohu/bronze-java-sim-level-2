package com.tw.exam;

import java.util.*;

public class Library {
    private final List<Book> books = new ArrayList<>();

    public void addAll(Book ...books) {
        this.books.addAll(Arrays.asList(books));
    }

    /**
     * Find all the books which contains one of the specified tags.
     *
     * @param tags The tag list.
     * @return The books which contains one of the specified tags. The returned books
     *   should be ordered by their ISBN number.
     */
    public List<Book> findBooksByTag(String ...tags) {
        // TODO:
        //   Please implement the method
        // <-start-
        List<Book> booksFound = findBooksByTagUnordered(tags);
        sortByIsbn(booksFound);
        return booksFound;
        // --end-->
    }

    private void sortByIsbn(List<Book> booksFound) {
        booksFound.sort(Comparator.comparing(Book::getIsbn));
    }

    private List<Book> findBooksByTagUnordered(String[] tags) {
        List<Book> booksFound = new ArrayList<>();
        Set<String> nonDuplicatedTags = distinct(tags);
        for (Book book : books) {
            if (containsTags(book, nonDuplicatedTags)) {
                booksFound.add(book);
            }
        }
        return booksFound;
    }

    private boolean containsTags(Book book, Set<String> tags) {
        for (String bookTag : book.getTags()) {
            if (tags.contains(bookTag)) {
                return true;
            }
        }

        return false;
    }

    private Set<String> distinct(String[] tags) {
        return new HashSet<>(Arrays.asList(tags));
    }

    // TODO:
    //   You can add additional methods here if you want.
    // <-start-

    // --end-->
}

