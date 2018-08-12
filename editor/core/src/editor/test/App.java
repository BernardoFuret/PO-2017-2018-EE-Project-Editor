package editor.test;

import editor.*;

import editor.exceptions.*;
import java.io.FileNotFoundException;

/**
 * Editor Test.
 */
public class App {

	private static void println( Object content ) {
		System.out.println( content );
	}

	public static void main( String[] args ) {

		// Test with:
		// - 3 different files:
		final String FILE_1 = "test1";
		final String FILE_2 = "test2";
		final String FILE_3 = "test3";
		// - 3 different users:
		final String USER_1 = "user1";
		final String USER_2 = "user2";
		final String USER_3 = "user3";

		// Editor instance:
		final Editor editor = new Editor();

		// Change the user using the editor:
		println( "Changing the user to " + USER_1 );
		editor.setUser( USER_1 );

		// Create a new document for the new user:
		println( "Creating document" );
		editor.create();

		// Assert:
		println( "Document creator: " + editor.getDocument().getCreator() );

		// Add elements to the Document:
		println( "Adding elements to the document and printing:" );
		editor.getDocument()
			.addChapter( "Chapter1" ) // id: 1
				.addSection( "Section1" ) // id: 2
					.addSection( "Sub-Section1" ) // id: 3
						.addParagraph() // id: 4
							.addSentence() // id: 5
								.addContent( "Sentence contained by " )
								.addContent( "a Paragraph, " )
								.addContent( "a Sub-Section, " )
								.addContent( "a Section, " )
								.addContent( "a Chapter " )
								.addContent( "and finally the Document!" );
		println( editor.getDocument().show( new ShowXMLVisitor() ) );

		// Changing user:
		println( "Changing the user to " + USER_2 );
		editor.setUser( USER_2 );

		// Getting elements:
		println( "Searching the Sub-Section1 (id: 3):" );
		try {
			println(
				editor.getDocument()
					.getChapter( 1 )
						.getSection( 2 )
							.getSection( 3 )
								.show( new ShowXMLVisitor() )
			);
		} catch ( NoSuchTextElementException e ) {
			println( e.getMessage() );
		}
		println( "Searching the Sub-Section1 (id: 3), but with the generic operation getTextElement():" );
		try {
			println(
				editor.getDocument()
					.getTextElement( 1 )
						.getTextElement( 2 )
							.getTextElement( 3 )
								.show( new ShowXMLVisitor() )
			);
		} catch ( NoSuchTextElementException e ) {
			println( e.getMessage() );
		}

		// Adding more elements:
		println( "Adding another chapter with a section and a paragraph to the Document:" );
		println( "(notice the 'latest-author' vs. 'creator' and also the dates.)" );
		try {
			println(
				editor.getDocument()
					.addChapter( "Chapter 2" ) // id: 6
						.addSection( "Section 2" ) // id: 7
							.getDocument()
								.getChapter( 6 )
									.addParagraph() // id: 8
										.getDocument()
											.show( new ShowXMLVisitor() )
			);
		} catch ( NoSuchTextElementException e ) {
			println( e.getMessage() );
		}

		// Getting elements that don't exist:
		println( "In Chapter 2, trying to get the section but providing the paragraph ID: (should throw)" );
		try {
			println(
				editor.getDocument()
					.getChapter( 6 )
						.getSection( 8 )
							.show( new ShowXMLVisitor() )

			);
		} catch ( NoSuchTextElementException e ) {
			println( "No Section with ID " + e.getId() );
		}

		println( "Same thing, but doing it generically:" );
		try {
			println(
				editor.getDocument()
					.getChapter( 6 )
						.getTextElement( 8 )
							.show( new ShowXMLVisitor() )

			);
		} catch ( NoSuchTextElementException e ) {
			println( "No Section with ID " + e.getId() );
		}

		// Removing elements:
		println( "Still in Chapter 2, remove the paragraph, but providing the section ID:" );
		try {
			editor.getDocument()
				.getChapter( 6 )
					.removeParagraph( 7 );
			println(
				editor.getDocument()
					.getChapter( 6 )
						.show( new ShowXMLVisitor() )

			);
		} catch ( NoSuchTextElementException e ) {
			println( "No Paragraph with ID " + e.getId() );
		}
		println( "Same thing, but doing it generically:" );
		try {
			editor.getDocument()
				.getChapter( 6 )
					.removeTextElement( 7 );
			println(
				editor.getDocument()
					.getChapter( 6 )
						.show( new ShowXMLVisitor() )

			);
		} catch ( NoSuchTextElementException e ) {
			println( "No Paragraph with ID " + e.getId() );
		}
		println( "Now, removing the paragraph:" );
		try {
			editor.getDocument()
				.getChapter( 6 )
					.removeParagraph( 8 );
			println(
				editor.getDocument()
					.getChapter( 6 )
						.show( new ShowXMLVisitor() )

			);
		} catch ( NoSuchTextElementException e ) {
			println( "No Paragraph with ID " + e.getId() );
		}

		println( "Full print of the Document to save:" );
		println( editor.getDocument().show( new ShowXMLVisitor() ) );
		try {
			editor.save( FILE_1 );
			println( "Saved as " + FILE_1 );
		} catch ( DocumentSaveException e ) {
			println( e.getMessage() );
		}

		//
		println( "--------" );

		// Change user:
		println( "Changing the user to " + USER_3 );
		editor.setUser( USER_3 );

		// Create a new document for the new user:
		println( "Creating document" );
		editor.create();

		println( editor.getDocument().show( new ShowXMLVisitor() ) );
		try {
			editor.save( FILE_2 );
			println( "Saved as " + FILE_2 );
		} catch ( DocumentSaveException e ) {
			println( e.getMessage() );
		}

		// Open the first document:
		println( "Opening " + FILE_1 );
		try {
			editor.open( FILE_1 );
			println( "Opened:" );
			println( editor.getDocument().show( new ShowXMLVisitor() ) );
			println( "And now in JSON:" );
			println( editor.getDocument().show( new ShowJSONVisitor() ) );
		} catch ( FileNotFoundException | DocumentOpenException e ) {
			println( e.getMessage() );
		}

		// Open something that doesn't exist:
		println( "Opening " + FILE_3 + " (doesn't exist (at least it shouldn't...))" );
		try {
			editor.open( FILE_3 );
			println( "Opened:" );
			println( editor.getDocument().show( new ShowXMLVisitor() ) );
		} catch ( FileNotFoundException | DocumentOpenException e ) {
			println( e.getMessage() );
		}

		// And I guess that's all.

	}

}