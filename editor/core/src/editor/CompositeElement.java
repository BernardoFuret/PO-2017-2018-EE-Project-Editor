package editor;

import java.util.List;
import java.util.ArrayList;

import editor.exceptions.NoSuchTextElementException;

/**
 * Composite element abstract class.
 * <p>
 * This hierarchy is based on a
 * <a href="https://www.l2f.inesc-id.pt/~david/w/pt/Composite_(padr%C3%A3o_de_desenho)">
 *   Composite Design Pattern
 * </a>, where this class represents the {@code Composite} element. This class
 * works as a meta-class for the concrete text elements that are not leafs.
 * This is to avoid duplicating code while keeping the same functionality,
 * extended from {@link TextElement} and implemented here, shared by the
 * concrete text elements (instead of each one of them nedding to implement
 * {@link #addTextElement( TextElement ) addTextElement}, etc., when they all
 * would do it the same way).
 * <p>
 * This also allows it to be easily extendible: If there's a need to add a new leaf,
 * just extend {@code TextElement}, as it'd be done with a typical Composite;
 * If there's a need to add a new text element that contains more text elements,
 * just extend this class.
 */
public abstract class CompositeElement extends TextElement {

	/** Serial number for serialization. */
	private static final long serialVersionUID = 2018_07_14_02_26L;

	/** Element content. */
	protected List<TextElement> content;

	/**
	 * Creates the content buffer for this element.
	 * @param document The document this element belongs to.
	 */
	public CompositeElement( Document document ) {
		super( document );
		this.content = new ArrayList<TextElement>();
	}

	/**
	 * @return The content buffer.
	 */
	public List<TextElement> getContent() {
		return this.content;
	}

	/**
	 * {@inheritDoc}
	 * @param textElement The TextElement to add.
	 * @see TextElement#addTextElement( TextElement )
	 */
	@Override
	protected final void addTextElement( TextElement textElement ) {
		this.content.add( textElement );
		this.document.updateData();
	}

	/**
	 * Returns a TextElement of a specific type, given an ID.
	 * <p>
	 * If such element doesn't exist in this element, it throws.
	 * <p>
	 * This method is simply an auxiliary, generic method
	 * to fetch TextElements of any type.
	 * @param id The ID to look for.
	 * @param cls The Class of the specific TextElement we want.
	 * @param <E> The specific Type of the TextElement we want.
	 * @return A TextElement of the specific Type {@code E} with the ID {@code id}.
	 * @throws NoSuchTextElementException If there's no such
	 * TextElement in this element with the ID {@code id}.
	 */
	protected final <E extends TextElement> E getTextElement( Class<E> cls, int id ) throws NoSuchTextElementException {
		for ( TextElement element : this.content ) {
			if (
				element.getId() == id
				&&
				cls.isAssignableFrom( element.getClass() )
			) {
				return cls.cast( element );
			}
		}

		throw new NoSuchTextElementException( id );
	}

	/**
	 * {@inheritDoc}
	 * @param id The ID to look for.
	 * @return A TextElement with the ID {@code id}.
	 * @throws NoSuchTextElementException If there's no such
	 * TextElement in this element with the ID {@code id}.
	 * @see TextElement#getTextElement( int )
	 */
	@Override
	public final TextElement getTextElement( int id ) throws NoSuchTextElementException {
		return this.<TextElement>getTextElement( TextElement.class, id );
	}

	/**
	 * Removes a TextElement, given an ID.
	 * <p>
	 * If such element doesn't exist in this element, it throws.
	 * <p>
	 * Updates the Document data after inserting the TextElement.
	 * <p>
	 * This method is simply an auxiliary, generic method
	 * to remove TextElements of any type.
	 * @param id The ID to look for.
	 * @param cls The Class of the specific TextElement to remove.
	 * @param <E> The specific Type of the TextElement to remove.
	 * @throws NoSuchTextElementException If there's no such
	 * TextElement in this element with the ID {@code id}.
	 */
	protected final <E extends TextElement> void removeTextElement( Class<E> cls, int id ) throws NoSuchTextElementException {
		for ( int index = 0; index < this.content.size(); index++ ) {
			TextElement element = this.content.get( index );
			if (
				element.getId() == id
				&&
				cls.isAssignableFrom( element.getClass() )
			) {
				this.content.remove( index );
				this.document.updateData();
				return;
			}
		}

		throw new NoSuchTextElementException( id );
	}

	/**
	 * {@inheritDoc}
	 * @param id The ID to look for.
	 * @throws NoSuchTextElementException If there's no such
	 * TextElement in this element with the ID {@code id}.
	 * @see TextElement#removeTextElement( int )
	 */
	@Override
	public final void removeTextElement( int id ) throws NoSuchTextElementException {
		this.<TextElement>removeTextElement( TextElement.class, id );
	}

	/**
	 * Counts the total number of characters in this document.
	 * @return The number of characters in this document.
	 * @see TextElement#charCount()
	 */
	@Override
	public int charCount() {
		return this.content.stream()
			.mapToInt( TextElement::charCount )
			.sum()
		;
	}

	/**
	 * Counts the total number of words in this document.
	 * @return The number of words in this document.
	 * @see TextElement#wordCount()
	 */
	@Override
	public int wordCount() {
		return this.content.stream()
			.mapToInt( TextElement::wordCount )
			.sum()
		;
	}

}
