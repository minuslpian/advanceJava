package pojos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="authors")
public class Author extends BaseEntity {
	@Column(length = 40,nullable = false)
	private String name;
	@Column(length = 30,unique = true)
	private String email;
//one to many 
	//mappedBy : MANDATORY : for bi dir asso. 
	//appears in inverse side
	//value : name of the asso prop as it appears in the owning side
	@OneToMany(mappedBy = "writer",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Book> books = new ArrayList<>();
	public Author() {
		System.out.println("in ctor of "+getClass());
	}
	
	public Author(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	//all s/g
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "Author " +getId()+"[name=" + name + ", email=" + email + "]";
	}
	//add 2 helper methods , for addBook , removeBook
	public void addBook(Book b)
	{
		//parent --> child
		books.add(b);
		//child ---> parent
		b.setWriter(this);
	}
	public void removeBook(Book b)
	{
		books.remove(b);
		b.setWriter(null);
	}
	
	
}
