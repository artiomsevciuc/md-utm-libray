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
public class Author extends Person {
	private Long id;
	private Date birthDate;
	private Date ripDate;
	private List<Books> writtenBooks;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Temporal(TemporalType.DATE)
	public Date getRipDate() {
		return ripDate;
	}

	public void setRipDate(Date ripDate) {
		this.ripDate = ripDate;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "written_books")
	public List<Books> getWrittenBooks() {
		return writtenBooks;
	}

	public void setWrittenBooks(List<Books> writtenBooks) {
		this.writtenBooks = writtenBooks;
	}

}
