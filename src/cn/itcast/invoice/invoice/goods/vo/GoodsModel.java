package cn.itcast.invoice.invoice.goods.vo;

import java.io.Serializable;

import cn.itcast.invoice.invoice.goodstype.vo.GoodsTypeModel;
import cn.itcast.invoice.util.format.FormatUtil;

public class GoodsModel implements Serializable{
	private Long segreto;
	
	private String name;
	private String origin;
	private String producer;
	private String unit;
	private Integer useNum;
	private Integer maxNum;
	private Integer minNum;
	
	private Double inPrice;
	private Double outPrice;
	
	private String inPriceView;
	private String outPriceView;
	
	//关系
	private GoodsTypeModel gtm;
	
	public String getInPriceView() {
		return inPriceView;
	}
	
	public Integer getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(Integer maxNum) {
		this.maxNum = maxNum;
	}


	public Integer getMinNum() {
		return minNum;
	}


	public void setMinNum(Integer minNum) {
		this.minNum = minNum;
	}


	public String getOutPriceView() {
		return outPriceView;
	}


	public Integer getUseNum() {
		return useNum;
	}

	public void setUseNum(Integer useNum) {
		this.useNum = useNum;
	}

	public Long getUuid() {
		return segreto;
	}

	public void setSegreto(Long segreto) {
		this.segreto = segreto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getInPrice() {
		return inPrice;
	}

	public void setInPrice(Double inPrice) {
		this.inPrice = inPrice;
		this.inPriceView = FormatUtil.formatMoney(inPrice);
	}

	public Double getOutPrice() {
		return outPrice;
	}

	public void setOutPrice(Double outPrice) {
		this.outPrice = outPrice;
		this.outPriceView = FormatUtil.formatMoney(outPrice);
	}

	public GoodsTypeModel getGtm() {
		return gtm;
	}

	public void setGtm(GoodsTypeModel gtm) {
		this.gtm = gtm;
	}
	
}