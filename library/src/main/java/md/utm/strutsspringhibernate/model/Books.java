package md.utm.strutsspringhibernate.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Books {
	private Long id;
	private String title;
	private String descriere;
	private Date publicaTionDate;
	private Date uploadDate;
	private Integer numberOfDownloads;
	private User uploader;
	private Author author;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescriere() {
		return descriere;
	}

	public void setDescriere(String descriere) {
		this.descriere = descriere;
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
