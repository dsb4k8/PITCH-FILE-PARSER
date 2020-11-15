package net.diegobrown.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FILE_SUBMISSIONS")
public class FileSubmissionEntity {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "symbol_clear_count")
	private String symbolClearCount;
	@Column(name = "add_order_short_count")
	private String addOrderShortCount;
	@Column(name = "add_order_long_count")
	private String addOrderLongCount;
	@Column(name = "order_executed_count")
	private String orderExecutedCount;
	@Column(name = "order_cancel_count")
	private String orderCancelCount;
	@Column(name = "trade_short_count")
	private String tradeShortCount;
	@Column(name = "trade_long_count")
	private String tradeLongCount;
	@Column(name = "trade_break_count")
	private String tradeBreakCount;
	@Column(name = "trade_status_count")
	private String TradeStatusCount;
	@Column(name = "auction_update_count")
	private String auctionUpdateCount;
	@Column(name = "auction_summary_count")
	private String auctionSummaryCount;

	//private String tradeLongCount;
	
	
	
	public Long getId() {
		return id;
	}

	public FileSubmissionEntity(String title, String symbolClearCount, String addOrderShortCount, String addOrderLongCount,
			String orderExecutedCount, String orderCancelCount, String tradeShortCount, String tradeLongCount,
			String tradeBreakCount, String tradeStatusCount, String auctionUpdateCount, String auctionSummaryCount) {
		this.title = title;
		this.symbolClearCount = symbolClearCount;
		this.addOrderShortCount = addOrderShortCount;
		this.addOrderLongCount = addOrderLongCount;
		this.orderExecutedCount = orderExecutedCount;
		this.orderCancelCount = orderCancelCount;
		this.tradeShortCount = tradeShortCount;
		this.tradeLongCount = tradeLongCount;
		this.tradeBreakCount = tradeBreakCount;
		this.TradeStatusCount = tradeStatusCount;
		this.auctionUpdateCount = auctionUpdateCount;
		this.auctionSummaryCount = auctionSummaryCount;
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
	public String getSymbolClearCount() {
		return symbolClearCount;
	}
	public void setSymbolClearCount(String symbolClearCount) {
		this.symbolClearCount = symbolClearCount;
	}
	public String getAddOrderShortCount() {
		return addOrderShortCount;
	}
	public void setAddOrderShortCount(String addOrderShortCount) {
		this.addOrderShortCount = addOrderShortCount;
	}
	public String getAddOrderLongCount() {
		return addOrderLongCount;
	}
	public void setAddOrderLongCount(String addOrderLongCount) {
		this.addOrderLongCount = addOrderLongCount;
	}
	public String getOrderExecutedCount() {
		return orderExecutedCount;
	}
	public void setOrderExecutedCount(String orderExecutedCount) {
		this.orderExecutedCount = orderExecutedCount;
	}
	public String getOrderCancelCount() {
		return orderCancelCount;
	}
	public void setOrderCancelCount(String orderCancelCount) {
		this.orderCancelCount = orderCancelCount;
	}
	public String getTradeShortCount() {
		return tradeShortCount;
	}
	public void setTradeShortCount(String tradeShortCount) {
		this.tradeShortCount = tradeShortCount;
	}
	public String getTradeLongCount() {
		return tradeLongCount;
	}
	public void setTradeLongCount(String tradeLongCount) {
		this.tradeLongCount = tradeLongCount;
	}
	public String getTradeBreakCount() {
		return tradeBreakCount;
	}
	public void setTradeBreakCount(String tradeBreakCount) {
		this.tradeBreakCount = tradeBreakCount;
	}
	public String getTradeStatusCount() {
		return TradeStatusCount;
	}
	public void setTradeStatusCount(String tradeStatusCount) {
		TradeStatusCount = tradeStatusCount;
	}
	public String getAuctionUpdateCount() {
		return auctionUpdateCount;
	}
	public void setAuctionUpdateCount(String auctionUpdateCount) {
		this.auctionUpdateCount = auctionUpdateCount;
	}
	public String getAuctionSummaryCount() {
		return auctionSummaryCount;
	}
	public void setAuctionSummaryCount(String auctionSummaryCount) {
		this.auctionSummaryCount = auctionSummaryCount;
	}
	
	@Override
	public String toString() {
		return "FileSubmission [id=" + id + ", title=" + title + ", symbolClearCount=" + symbolClearCount + "]";
	}
	


}
