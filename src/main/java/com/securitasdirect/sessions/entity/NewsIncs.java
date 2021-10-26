package com.securitasdirect.sessions.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "news_incs")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "NewsIncs.findAll", query = "SELECT n FROM NewsIncs n"),
		@NamedQuery(name = "NewsIncs.findByText", query = "SELECT n FROM NewsIncs n WHERE n.text = :text"),
		@NamedQuery(name = "NewsIncs.findByStartDate", query = "SELECT n FROM NewsIncs n WHERE n.startDate = :startDate"),
		@NamedQuery(name = "NewsIncs.findByEndDate", query = "SELECT n FROM NewsIncs n WHERE n.endDate = :endDate"),
		@NamedQuery(name = "NewsIncs.findByColor", query = "SELECT n FROM NewsIncs n WHERE n.color = :color"),
		@NamedQuery(name = "NewsIncs.findById", query = "SELECT n FROM NewsIncs n WHERE n.id = :id") })
public class NewsIncs implements Serializable {
	private static final long serialVersionUID = 1L;
	@Size(max = 1024)
	@Column(name = "text")
	private String text;
	@Basic(optional = false)
	@NotNull
	@Column(name = "startDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	@Basic(optional = false)
	@NotNull
	@Column(name = "endDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "color")
	private String color;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "id")
	private Integer id;

	public NewsIncs() {
	}

	public NewsIncs(Integer id) {
		this.id = id;
	}

	public NewsIncs(Integer id, Date startDate, Date endDate, String color) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.color = color;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int hashCode() {
		int hash = 0;
		hash += (this.id != null) ? this.id.hashCode() : 0;
		return hash;
	}

	public boolean equals(Object object) {
		if (!(object instanceof com.securitasdirect.sessions.entity.NewsIncs)) {
			return false;
		}
		com.securitasdirect.sessions.entity.NewsIncs other = (com.securitasdirect.sessions.entity.NewsIncs) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	public String toString() {
		return "com.securitasdirect.wsusersinstaut.entity.NewsIncs[ id=" + this.id + " ]";
	}
}
