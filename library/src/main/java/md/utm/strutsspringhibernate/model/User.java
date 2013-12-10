package md.utm.strutsspringhibernate.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User extends Person {

	private Long id;
	private String email;
	private String password;
	private Date createdDate;
	private List<Books> uploadedBooks;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.DATE)
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "uploaded_books")
	public List<Books> getUploadedBooks() {
		return uploadedBooks;
	}

	public void setUploadedBooks(List<Books> uploadedBooks) {
		this.uploadedBooks = uploadedBooks;
	}

}
