/*
 * Copyright (c) 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package googleApi;

import business.Book;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.BooksRequestInitializer;
import com.google.api.services.books.Books.Volumes.List;
import com.google.api.services.books.model.Volume;
import com.google.api.services.books.model.Volume.VolumeInfo.IndustryIdentifiers;
import com.google.api.services.books.model.Volumes;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * A sample application that demonstrates how Google Books Client Library for
 * Java can be used to query Google Books. It accepts queries in the command
 * line, and prints the results to the console.
 *
 * $ java com.google.sample.books.BookSearch [--author|--isbn|--title] "<query>"
 *
 * Please start by reviewing the Google Books API documentation at:
 * http://code.google.com/apis/books/docs/getting_started.html
 */
public class BookSearch {

    /**
     * Be sure to specify the name of your application. If the application name
     * is {@code null} or blank, the application will log a warning. Suggested
     * format is "MyCompany-ProductName/1.0".
     */
    private static final String APPLICATION_NAME = "ReadThatBook";

    private static final NumberFormat CURRENCY_FORMATTER = NumberFormat.getCurrencyInstance();
    private static final NumberFormat PERCENT_FORMATTER = NumberFormat.getPercentInstance();

    public static java.util.List<Book> queryGoogleBooks(JsonFactory jsonFactory, String query) throws Exception {
        ClientCredentials.errorIfNotSpecified();

        // Set up Books client.
        final Books books = new Books.Builder(GoogleNetHttpTransport.newTrustedTransport(), jsonFactory, null)
                .setApplicationName(APPLICATION_NAME)
                .setGoogleClientRequestInitializer(new BooksRequestInitializer(ClientCredentials.API_KEY))
                .build();

        // Set query string and filter only Google eBooks.
        System.out.println("Query: [" + query + "]");
        List volumesList = books.volumes().list(query);
        volumesList.setFilter("ebooks");

        // Execute the query.
        Volumes volumes = volumesList.execute();
        if (volumes.getTotalItems() == 0 || volumes.getItems() == null) {
            System.out.println("No matches found.");
            return null;
        }

        ArrayList bookList = new ArrayList();

        // Output results.
        for (Volume volume : volumes.getItems()) {

            int bookID;
            String title;
            String author = null;
            String ISBN10 = null;
            String ISBN13 = null;
            String genre = null;
            String edition = null;
            String publisher = null;
            String description = null;
            String imageLink = null;

            Volume.VolumeInfo volumeInfo = volume.getVolumeInfo();
            Volume.SaleInfo saleInfo = volume.getSaleInfo();
            System.out.println("==========");

            // Title.
            title = volumeInfo.getTitle();
            System.out.println("Title: " + title);
            if (volumeInfo.getIndustryIdentifiers() != null) {
                for (IndustryIdentifiers iden : volumeInfo.getIndustryIdentifiers()) {
                    if (iden.getType().equals("ISBN_13")) {
                        ISBN13 = iden.getIdentifier();
                        System.out.println("ISBN13 : " + ISBN13);
                    } else if (iden.getType().equals("ISBN_10")) {
                        ISBN10 = iden.getIdentifier();
                        System.out.println("ISBN10 : " + ISBN10);
                    }
                }
            }

            System.out.println("Title: " + title);

            //authors
            java.util.List<String> authors = volumeInfo.getAuthors();
            if (authors != null && !authors.isEmpty()) {
                System.out.print("Author(s): ");
                for (int i = 0; i < authors.size(); ++i) {
                    System.out.print(authors.get(i));
                    if (i == 0) {
                        author = authors.get(i);
                    } else if (i != 0 && i <= authors.size()) {
                        author = author + ", " + authors.get(i);
                    }

                    //author = authors.get(i) + ", " + author;
                    if (i < authors.size() - 1) {
                        System.out.print(", ");
                        // author = author + ", " + authors.get(i);
                    }
                }
                System.out.println();
            }

            // Description (if any).
            if (volumeInfo.getDescription() != null && volumeInfo.getDescription().length() > 0) {

                description = volumeInfo.getDescription();
                System.out.println("Description: " + description);
            }

            //publisher
            if (volumeInfo.getPublisher() != null) {
                publisher = volumeInfo.getPublisher();
            }

            //image link
            if (volumeInfo.getImageLinks() != null) {
                imageLink = volumeInfo.getImageLinks().getThumbnail();
            }

            if (volumeInfo.getCategories() != null) {
                int length = 0;
                length = volumeInfo.getCategories().toString().length();
                genre = volumeInfo.getCategories().toString().substring(1, length - 1);
            }

            Book googleBook;
            googleBook = new Book(title, author, ISBN10, ISBN13, genre, edition, publisher, description);
            googleBook.setImageLink(imageLink);
            boolean add = bookList.add(googleBook);
//            // Access status.
//            String accessViewStatus = volume.getAccessInfo().getAccessViewStatus();
//            String message = "Additional information about this book is available from Google eBooks at:";
//            if ("FULL_PUBLIC_DOMAIN".equals(accessViewStatus)) {
//                message = "This public domain book is available for free from Google eBooks at:";
//            } else if ("SAMPLE".equals(accessViewStatus)) {
//                message = "A preview of this book is available from Google eBooks at:";
//            }
//            System.out.println(message);
//            // Link to Google eBooks.
//            System.out.println(volumeInfo.getInfoLink());
        }

        System.out.println("==========");
        System.out.println(
                volumes.getTotalItems() + " total results at http://books.google.com/ebooks?q="
                + URLEncoder.encode(query, "UTF-8"));
        return bookList;
    }

    public static String parseQuery(String args) {
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
        try {
            // Verify command line parameters.
//      if (args.length == 0) {
//        System.err.println("Usage: BooksSample [--author|--isbn|--title] \"<query>\"");
//        System.exit(1);
//      }

            // Parse command line parameters into a query.
            // Query format: "[<author|isbn|intitle>:]<query>"
            String prefix = null;
            String query = "";
//            for (String arg : args) {
//                if ("--author".equals(arg)) {
//                    prefix = "inauthor:";
//                } else if ("--isbn".equals(arg)) {
//                    prefix = "isbn:";
//                } else if ("--title".equals(arg)) {
//                    prefix = "intitle:";
//                } else if (arg.startsWith("--")) {
//                    System.err.println("Unknown argument: " + arg);
//                    System.exit(1);
//                } else {
//                    query = arg;
//                }
//            }

//            if (args.contains("--author")) {
//                prefix = "inauthor:";
//            } else if (args.contains("--isbn")) {
//                prefix = "isbn:";
//            } else if (args.contains("--title")) {
//                prefix = "intitle:";
//            } else if (args.startsWith("--")) {
//                System.err.println("Unknown argument: " + args);
//                System.exit(1);
//            } else {
//                query = args;
//            }
            args.replace("", "");
            System.out.println("prefix : " + prefix);
            if (prefix != null) {
                query = prefix + query;
            }

            return query;
//            try {
//                queryGoogleBooks(jsonFactory, query);
//                // Success!
//                return;
//            } catch (IOException e) {
//                System.err.println(e.getMessage());
//            }
        } catch (Throwable t) {
            t.printStackTrace();
            return "";
        }

    }

}
