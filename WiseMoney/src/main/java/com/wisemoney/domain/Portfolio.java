package com.wisemoney.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PORTFOLIO")
public class Portfolio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7893649903083151674L;

	@Id
	@Column(name="ID", unique=true)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PortfolioCountSequence")
	@SequenceGenerator(allocationSize=1, name="PortfolioCountSequence", sequenceName="PORTFOLIO_COUNT_SEQ")
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PORTFOLIO_ID")
	private User portfolioId;
	
	@Column(name="DATE_CREATED")
	private Timestamp dateCreated;
	
	@Column(name="LAST_UPDATED")
	private Timestamp lastUpdated;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="STOCK")
	private List<Stock> stock;
	
	@Column(name="VOLUME")
	private int volume;
	
	@Column(name="TOTAL_VALUE")
	private int totalValue;
	
	public Portfolio(User portfolioId, Timestamp dateCreated, Timestamp lastUpdated, int volume,
			int totalValue) {
		super();
		this.portfolioId = portfolioId;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.volume = volume;
		this.totalValue = totalValue;
	}
	
	public Portfolio(User portfolioId, Timestamp dateCreated, Timestamp lastUpdated, List<Stock> stock, int volume,
			int totalValue) {
		super();
		this.portfolioId = portfolioId;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.stock = stock;
		this.volume = volume;
		this.totalValue = totalValue;
	}
	
	public Portfolio() {
		// TODO Auto-generated constructor stub
	}

	public User getPortfolioId() {
		return portfolioId;
	}
	public void setPortfolioId(User portfolioId) {
		this.portfolioId = portfolioId;
	}
	public Timestamp getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Stock> getStock() {
		return stock;
	}

	public void setStock(List<Stock> stock) {
		this.stock = stock;
	}

	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public int getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}

	@Override
	public String toString() {
		return "Portfolio [portfolioId=" + portfolioId + ", dateCreated=" + dateCreated + ", lastUpdated=" + lastUpdated
				+ ", stock=" + stock + ", volume=" + volume + ", totalValue=" + totalValue + "]";
	}
	
	
	
	
	

}
