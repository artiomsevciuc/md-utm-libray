package md.utm.strutsspringhibernate.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Book {
	private Integer id;
	private String title;
	private String description;
	private Date publicaTionDate;
	private Date uploadDate;
	private Integer numberOfDownloads;
	private User uploader;
	private Author author;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.DATE)
	public Date getPublicaTionDate() {
		return publicaTionDate;
	}

	public void setPublicaTionDate(Date publicaTionDate) {
		this.publicaTionDate = publicaTionDate;
	}

	@Temporal(TemporalType.DATE)
	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public Integer getNumberOfDownloads() {
		return numberOfDownloads;
	}

	public void setNumberOfDownloads(Integer numberOfDownloads) {
		this.numberOfDownloads = numberOfDownloads;
	}

	@ManyToOne
	@JoinTable(name = "uploaded_books", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "uploader_id"))
	public User getUploader() {
		return uploader;
	}

	public void setUploader(User uploader) {
		this.uploader = uploader;
	}

	@ManyToOne
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}
