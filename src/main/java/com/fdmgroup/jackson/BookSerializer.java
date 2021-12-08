package com.fdmgroup.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class BookSerializer extends StdSerializer<Book>{

	protected BookSerializer(Class <Book> t) {
		super(t);
		// TODO Auto-generated constructor stub
	}
	public BookSerializer() {
		this(null);
	}

	@Override
	public void serialize(Book value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		// TODO Auto-generated method stub
		gen.writeStartObject();
		gen.writeStringField("title", value.getTitle());
		gen.writeStringField("author", value.getAuthor());
		gen.writeStringField("isbn", value.getIsbn());
		
		gen.writeEndObject();
		
	}

}
