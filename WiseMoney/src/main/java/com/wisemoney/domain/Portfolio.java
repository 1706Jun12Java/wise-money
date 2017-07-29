package com.wisemoney.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="WM_PORTFOLIO")
public class Portfolio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7893649903083151674L;

	@Id
	@Column(name="P_ID", unique=true)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PortfolioCountSequence")
	@SequenceGenerator(allocationSize=1, name="PortfolioCountSequence", sequenceName="PORTFOLIO_COUNT_SEQ")
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="USER_ID")
	private User userId;
	
	@Column(name="DATE_CREATED")
	private Date dateCreated;
	
	@Column(name="LAST_UPDATED")
	private Date lastUpdated;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="STOCK_ID")
	private Stock stockId;
	
	@Column(name="VOLUME")
	private int volume;
	
	@Column(name="TOTAL_VALUE")
	private double totalValue;
	
	@Column(name="LAST_TRANSACTION")
	private String lastTx;
	
	public Portfolio(User userId, Date dateCreated, Date lastUpdated, Stock stockId, int volume, 
			double totalValue, String lastTx) {
		super();
		this.userId = userId;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.stockId=stockId;
		this.volume = volume;
		this.totalValue=totalValue;
		this.lastTx=lastTx;
	}
	
	/*
	public Portfolio(User userId, Timestamp dateCreated, Timestamp lastUpdated, List<Stock> stock, int volume, double totalValue) {
		super();
		this.userId = userId;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.stock = stock;
		this.volume = volume;
		this.totalValue=totalValue;
	}*/ 
	
	public Portfolio() {
		// TODO Auto-generated constructor stub
	}

	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}	
	
	public Stock getStockId() {
		return stockId;
	}

	public void setStockId(Stock stockId) {
		this.stockId=stockId;
	}

	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	public String getLastTx() {
		return lastTx;
	}
	public void setLastTx(String lastTx) {
		this.lastTx=lastTx;
	}
	
	@Override
	public String toString() {
		return "Portfolio [userId=" + userId + ", dateCreated=" + dateCreated + ", lastUpdated=" + lastUpdated
				+ ", stockId=" + stockId + ", volume=" + volume + ", totalValue=" + totalValue +", "
						+ "lastTx=" + lastTx + "]";
	}
}
