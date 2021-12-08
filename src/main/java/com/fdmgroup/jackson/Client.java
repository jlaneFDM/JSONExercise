package com.fdmgroup.jackson;

import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Client {

	public static void main(String[] args) {

		try {
			String filePath = "src/main/resources/books.json";
			FileReader booksFile = new FileReader(filePath);
			ObjectMapper om = new ObjectMapper();

			Book[] books = om.readValue(booksFile, Book[].class);
			List<Book> bookList = Arrays.asList(books);

			Collections.sort(bookList);

			String writeFilePath = "src/main/resources/sorted-books.json";
			File sortedBooks = new File(writeFilePath);

			if (!sortedBooks.exists()) {
				sortedBooks.createNewFile();
			}

			Book[] sortedBookArray = new Book[bookList.size()];
			bookList.toArray(sortedBookArray);

			String serialized = "";

			serialized = om.writeValueAsString(sortedBookArray);

			JsonFactory jf = om.getFactory();
			JsonParser jParser = jf.createParser(serialized);

			Book[] b = new ObjectMapper().readValue(jParser, Book[].class);

			om.writerWithDefaultPrettyPrinter().writeValue(sortedBooks, b);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
