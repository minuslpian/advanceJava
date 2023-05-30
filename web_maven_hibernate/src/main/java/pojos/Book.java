package pojos;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book extends BaseEntity {
	@Column(length = 100,unique = true)
	private String title;
//many to one
	@ManyToOne
	//to specify name of the FK col : 
	@JoinColumn(name = "author_id")
	private Author writer;

	public Book() {
		System.out.println("in ctor of " + getClass());
	}
	

	public Book(String title) {
		super();
		this.title = title;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getWriter() {
		return writer;
	}

	public void setWriter(Author writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "Book " + getId() + "  [title=" + title + "]";
	}

}
