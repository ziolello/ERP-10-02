package cn.itcast.invoice.invoice.order.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.itcast.invoice.auth.emp.business.ebi.EmpEbi;
import cn.itcast.invoice.auth.emp.vo.EmpModel;
import cn.itcast.invoice.invoice.goods.business.ebi.GoodsEbi;
import cn.itcast.invoice.invoice.goods.vo.GoodsModel;
import cn.itcast.invoice.invoice.goodstype.business.ebi.GoodsTypeEbi;
import cn.itcast.invoice.invoice.goodstype.vo.GoodsTypeModel;
import cn.itcast.invoice.invoice.order.business.ebi.OrderDetailEbi;
import cn.itcast.invoice.invoice.order.business.ebi.OrderEbi;
import cn.itcast.invoice.invoice.order.vo.OrderDetailModel;
import cn.itcast.invoice.invoice.order.vo.OrderModel;
import cn.itcast.invoice.invoice.order.vo.OrderQueryModel;
import cn.itcast.invoice.invoice.store.business.ebi.StoreEbi;
import cn.itcast.invoice.invoice.store.vo.StoreModel;
import cn.itcast.invoice.invoice.supplier.business.ebi.SupplierEbi;
import cn.itcast.invoice.invoice.supplier.vo.SupplierModel;
import cn.itcast.invoice.util.base.BaseAction;

public class OrderAction extends BaseAction{
	public OrderModel om = new OrderModel();
	public OrderQueryModel oqm = new OrderQueryModel();

	private OrderEbi orderEbi;
	private SupplierEbi supplierEbi;
	private GoodsTypeEbi goodsTypeEbi;
	private GoodsEbi goodsEbi;
	private EmpEbi empEbi;
	private StoreEbi storeEbi;
	private OrderDetailEbi orderDetailEbi;
	
	public void setOrderDetailEbi(OrderDetailEbi orderDetailEbi) {
		this.orderDetailEbi = orderDetailEbi;
	}

	public void setStoreEbi(StoreEbi storeEbi) {
		this.storeEbi = storeEbi;
	}

	public void setEmpEbi(EmpEbi empEbi) {
		this.empEbi = empEbi;
	}

	public void setGoodsEbi(GoodsEbi goodsEbi) {
		this.goodsEbi = goodsEbi;
	}

	public void setGoodsTypeEbi(GoodsTypeEbi goodsTypeEbi) {
		this.goodsTypeEbi = goodsTypeEbi;
	}

	public void setSupplierEbi(SupplierEbi supplierEbi) {
		this.supplierEbi = supplierEbi;
	}

	public void setOrderEbi(OrderEbi orderEbi) {
		this.orderEbi = orderEbi;
	}

	//Ã¨Â·Â³Ã¨Â½Â¬Ã¥Ë†Â°Ã¥Ë†â€”Ã¨Â¡Â¨Ã©Â¡ÂµÃ©ï¿½Â¢
	public String list(){
		setDataTotal(orderEbi.getCount(oqm));
		List<OrderModel> orderList = orderEbi.getAll(oqm,pageNum,pageCount);
		put("orderList",orderList);
		return LIST;
	}

	//Ã¤Â¿ï¿½Ã¥Â­Ëœ/Ã¤Â¿Â®Ã¦â€�Â¹
	public String save(){
		if(om.getUuid()== null){
			orderEbi.save(om);
		}else{
			orderEbi.update(om);
		}
		return TO_LIST;
	}

	//Ã¨Â·Â³Ã¨Â½Â¬Ã¥Ë†Â°Ã¦Â·Â»Ã¥Å Â /Ã¤Â¿Â®Ã¦â€�Â¹Ã©Â¡ÂµÃ©ï¿½Â¢
	public String input(){
		if(om.getUuid()!=null){
			om = orderEbi.get(om.getUuid());
		}
		return INPUT;
	}
	//Ã¨Â·Â³Ã¨Â½Â¬Ã¥Ë†Â°Ã©â€¡â€¡Ã¨Â´Â­Ã¨Â®Â¢Ã¥ï¿½â€¢Ã©Â¡Âµ
	
	public String buyInput(){
		List<SupplierModel> supplierList = supplierEbi.getAll();
		//Ã¥ï¿½ËœÃ¦Ë†ï¿½Ã¨Â¿â€¡Ã¦Â»Â¤Ã¨Â¯Â¥Ã¦â€¢Â°Ã¦ï¿½Â®
		//Ã¦Å“â€°Ã§Â±Â»Ã¥Ë†Â«Ã¤Â½â€ Ã¦ËœÂ¯Ã§Â±Â»Ã¥Ë†Â«Ã¤Â¸Â­Ã¦Â²Â¡Ã¦Å“â€°Ã¥â€¢â€ Ã¥â€œï¿½Ã§Å¡â€žÃ§Â±Â»Ã¥Ë†Â«Ã¨Â¿â€¡Ã¦Â»Â¤Ã¦Å½â€°
		//Ã¦Â²Â¡Ã¦Å“â€°Ã§Â±Â»Ã¥Ë†Â«Ã§Å¡â€žÃ¤Â¾â€ºÃ¥Âºâ€�Ã¥â€¢â€ Ã¨Â¿â€¡Ã¦Â»Â¤Ã¦Å½â€°
		//Ã¥Â¾ÂªÃ§Å½Â¯Ã¦â€°â‚¬Ã¦Å“â€°Ã§Å¡â€žÃ¤Â¾â€ºÃ¥Âºâ€�Ã¥â€¢â€ Ã¯Â¼Å’Ã¥Ë†Â¤Ã¥Â®Å¡Ã¨Â¯Â¥Ã¤Â¾â€ºÃ¥Âºâ€�Ã¥â€¢â€ Ã¦ËœÂ¯Ã¥ï¿½Â¦Ã¤Â¿ï¿½Ã§â€¢â„¢Ã¯Â¼Å’Ã¥Â¦â€šÃ¦Å¾Å“Ã¤Â¸ï¿½Ã¤Â¿ï¿½Ã§â€¢â„¢Ã¥Ë†Â Ã©â„¢Â¤
		/*
		for(int i = supplierList.size()-1;i>=0;i--){
			SupplierModel sm = supplierList.get(i);
			List<GoodsTypeModel> gtms = new ArrayList(sm.getGtms());
			//Ã¥Â¾ÂªÃ§Å½Â¯Ã¥â€¢â€ Ã¥â€œï¿½Ã§Â±Â»Ã¥Ë†Â«Ã¤Â¸Â­Ã§Å¡â€žÃ¦â€¢Â°Ã¦ï¿½Â®
			for(int j = gtms.size()-1;j>=0;j--){
				GoodsTypeModel gtm = gtms.get(j);
				if(gtm.getGms().size() == 0){
					gtms.remove(j);
				}
			}
			if(gtms.size() == 0){
				supplierList.remove(i);
			}
		}
		*/
		int flag=0;
		for(int i = supplierList.size()-1;i>=0;i--){
			flag=0;
			SupplierModel sm = supplierList.get(i);
			//List<GoodsTypeModel> gtms = new ArrayList(sm.getGtms());
			//Ã¦â‚¬Â§Ã¨Æ’Â½Ã¤Â¼ËœÃ¤ÂºÅ½Ã¤Â¸Å Ã©ï¿½Â¢Ã§Å¡â€žÃ¦â€“Â¹Ã¦Â¡Ë†
			List<GoodsTypeModel> gtms = goodsTypeEbi.getAllBySupplier(sm.getUuid());
			//Ã¥Â¾ÂªÃ§Å½Â¯Ã¥â€¢â€ Ã¥â€œï¿½Ã§Â±Â»Ã¥Ë†Â«Ã¤Â¸Â­Ã§Å¡â€žÃ¦â€¢Â°Ã¦ï¿½Â®
			for(int j = gtms.size()-1;j>=0;j--){
				GoodsTypeModel gtm = gtms.get(j);
				if(gtm.getGms().size() > 0){
					flag=1;
					continue;
				}
			}
			if(flag==1) {
				continue;
		    }else supplierList.remove(i);
		}

		List<GoodsTypeModel> gtmList = goodsTypeEbi.getAllUnionBySupplier(supplierList.get(0).getUuid());
		List<GoodsModel> gmList = goodsEbi.getAllByGtmUuid(gtmList.get(0).getUuid());
		put("supplierList",supplierList);
		put("gtmList",gtmList);
		put("gmList",gmList);
		return "buyInput";
	}
	
	/*
	public static void main(String[] args) {
		List<String> al = new ArrayList<String>();
		
		al.add("aa1");
		al.add("bb1");
		al.add("cc1");
		al.add("dd");
		
		for(int i = al.size()-1;i>=0;i--){
			String s = al.get(i);
			if(s.contains("1")){
				al.remove(i);
			}
		}
		
		for(String s:al){
			System.out.println(s);
		}
	}
	*/
	
	
	/*
	public String buyInput(){
		//Ã¥Å Â Ã¨Â½Â½Ã¤Â¾â€ºÃ¥Âºâ€�Ã¥â€¢â€ Ã¦â€¢Â°Ã¦ï¿½Â®
		//Ã©â€”Â®Ã©Â¢ËœÃ¯Â¼Å¡Ã¤Â¸ÂªÃ¥Ë†Â«Ã¦Â²Â¡Ã¦Å“â€°Ã¥â€¢â€ Ã¥â€œï¿½Ã§Â±Â»Ã¥Ë†Â«Ã§Å¡â€žÃ¤Â¾â€ºÃ¥Âºâ€�Ã¥â€¢â€ Ã¤Â¸ï¿½Ã¥Âºâ€�Ã¨Â¯Â¥Ã¨Â¢Â«Ã¥Å Â Ã¨Â½Â½
		//Ã¨Â§Â£Ã¥â€ Â³Ã¦â€“Â¹Ã¦Â¡Ë†Ã¤Â¸â‚¬Ã¯Â¼Å¡
		//Ã¨Â¯Â»Ã¥ï¿½â€“Ã¦â€°â‚¬Ã¦Å“â€°Ã¦â€¢Â°Ã¦ï¿½Â®Ã¥ï¿½Å½Ã¯Â¼Å’Ã©â‚¬Å¡Ã¨Â¿â€¡Ã¨Â¿Â­Ã¤Â»Â£Ã©â€ºâ€ Ã¥ï¿½Ë†Ã¥Â°â€ Ã¦â€°â‚¬Ã¦Å“â€°Ã¦Â²Â¡Ã¦Å“â€°Ã§Â±Â»Ã¥Ë†Â«Ã§Å¡â€žÃ¤Â¾â€ºÃ¥Âºâ€�Ã¥â€¢â€ Ã¥Ë†Â Ã©â„¢Â¤Ã¦Å½â€°
		//Ã¨Â§Â£Ã¥â€ Â³Ã¦â€“Â¹Ã¦Â¡Ë†Ã¤ÂºÅ’Ã¯Â¼Å¡
		//Ã¦Å¸Â¥Ã¨Â¯Â¢Ã¦â€¢Â°Ã¦ï¿½Â®Ã¦â€”Â¶Ã¯Â¼Å’Ã§â€ºÂ´Ã¦Å½Â¥Ã¥Â°â€ Ã¦Â²Â¡Ã¦Å“â€°Ã¥â€¢â€ Ã¥â€œï¿½Ã§Â±Â»Ã¥Ë†Â«Ã§Å¡â€žÃ¤Â¾â€ºÃ¥Âºâ€�Ã¥â€¢â€ Ã¨Â¿â€¡Ã¦Â»Â¤Ã¦Å½â€°
		//Ã¦Å¸Â¥Ã¤Â¾â€ºÃ¥Âºâ€�Ã¥â€¢â€   Ã¤Â¾â€ºÃ¥Âºâ€�Ã¥â€¢â€ Ã¥â€¦Â³Ã¨ï¿½â€�Ã§Â±Â»Ã¥Ë†Â«
		//Ã©â€”Â®Ã©Â¢ËœÃ¥Ë†â€ Ã¦Å¾ï¿½Ã¯Â¼Å¡Ã¦Å¸ï¿½Ã¤Â¸ÂªÃ¤Â¾â€ºÃ¥Âºâ€�Ã¥â€¢â€ Ã¥â€¦Â·Ã¦Å“â€°Ã¥Â¤Å¡Ã¤Â¸ÂªÃ¥â€¢â€ Ã¥â€œï¿½Ã§Â±Â»Ã¥Ë†Â«Ã¯Â¼Å’Ã¤Â½â€ Ã¦ËœÂ¯Ã§Â±Â»Ã¥Ë†Â«Ã¤Â¸Â­Ã¦Â²Â¡Ã¦Å“â€°Ã¥â€¢â€ Ã¥â€œï¿½Ã¯Â¼Å¸
		//Ã¦Å¸Â¥Ã¤Â¾â€ºÃ¥Âºâ€�Ã¥â€¢â€   Ã¤Â¾â€ºÃ¥Âºâ€�Ã¥â€¢â€ Ã¥â€¦Â³Ã¨ï¿½â€�Ã§Â±Â»Ã¥Ë†Â«Ã¯Â¼Å’Ã§Â±Â»Ã¥Ë†Â«Ã¥â€¦Â³Ã¨ï¿½â€�Ã¥â€¢â€ Ã¥â€œï¿½ distinct
		List<SupplierModel> supplierList = supplierEbi.getAllUnionTwo();
		//Ã¥Å Â Ã¨Â½Â½Ã§Â¬Â¬Ã¤Â¸â‚¬Ã¤Â¸ÂªÃ¤Â¾â€ºÃ¥Âºâ€�Ã¥â€¢â€ Ã§Å¡â€žÃ§Â±Â»Ã¥Ë†Â«Ã¦â€¢Â°Ã¦ï¿½Â®
		/*
		1Ã¥ï¿½Â·		A	B	C
				a1	b1	
				a2	b2
				a3
		*/
	/*
		List<GoodsTypeModel> gtmList = goodsTypeEbi.getAllUnionBySupplier(supplierList.get(0).getUuid());
		//Ã¥Å Â Ã¨Â½Â½Ã§Â¬Â¬Ã¤Â¸â‚¬Ã¤Â¸ÂªÃ§Â±Â»Ã¥Ë†Â«Ã§Å¡â€žÃ¥â€¢â€ Ã¥â€œï¿½Ã¦â€¢Â°Ã¦ï¿½Â®
		List<GoodsModel> gmList = goodsEbi.getAllByGtmUuid(gtmList.get(0).getUuid());
		//Ã¥Å Â Ã¨Â½Â½Ã§Â¬Â¬Ã¤Â¸â‚¬Ã¤Â¸ÂªÃ¥â€¢â€ Ã¥â€œï¿½Ã§Å¡â€žÃ¤Â»Â·Ã¦Â Â¼Ã¦â€¢Â°Ã¦ï¿½Â®(Ã§Å“ï¿½Ã§â€¢Â¥)
		//GoodsModel gm = gmList.get(0);
		//put("gm",gm);
		/*
		put("supplierList",supplierList);
		put("gtmList",gtmList);
		put("gmList",gmList);
		
		return "buyInput";
	}*/

	//Ã¥Ë†Â Ã©â„¢Â¤
	public String delete(){
		orderEbi.delete(om);
		return TO_LIST;
	}
	
	//--ajax----------------------------
	public Long supplierUuid;
	public Long goodsTypeUuid;
	public Long goodsUuid;
	public String used;
	
	private List<GoodsTypeModel> gtmList;
	private List<GoodsModel> gmList;
	private GoodsModel gm;
	
	public GoodsModel getGm() {
		return gm;
	}
	public List<GoodsTypeModel> getGtmList() {
		return gtmList;
	}
	public List<GoodsModel> getGmList() {
		return gmList;
	}

	public String ajaxGetGtmAndGm(){
		//Ã¦Â Â¹Ã¦ï¿½Â®Ã¤Â¾â€ºÃ¥Âºâ€�Ã¥â€¢â€ Ã§Å¡â€žuuidÃ¨Å½Â·Ã¥ï¿½â€“Ã§Â±Â»Ã¥Ë†Â«Ã¦â€¢Â°Ã¦ï¿½Â®Ã¤Â¸Å½Ã¥â€¢â€ Ã¥â€œï¿½Ã¦â€¢Â°Ã¦ï¿½Â®
		//Ã§Â±Â»Ã¥Ë†Â«Ã¤Â¸Â­Ã¥Â¿â€¦Ã©Â¡Â»Ã¦Å“â€°Ã¥â€¢â€ Ã¥â€œï¿½
		gtmList = goodsTypeEbi.getAllUnionBySupplier(supplierUuid);
		//Ã¦Â Â¹Ã¦ï¿½Â®Ã§Â¬Â¬Ã¤Â¸â‚¬Ã¤Â¸ÂªÃ¥â€¢â€ Ã¥â€œï¿½Ã§Â±Â»Ã¥Ë†Â«Ã¨Å½Â·Ã¥ï¿½â€“Ã¥Â¯Â¹Ã¥Âºâ€�Ã§Å¡â€žÃ¦â€°â‚¬Ã¦Å“â€°Ã¥â€¢â€ Ã¥â€œï¿½
		gmList = goodsEbi.getAllByGtmUuid(gtmList.get(0).getUuid());
		//Ã¨Å½Â·Ã¥ï¿½â€“Ã§Â¬Â¬Ã¤Â¸â‚¬Ã¤Â¸ÂªÃ¥â€¢â€ Ã¥â€œï¿½Ã¤Â¿Â¡Ã¦ï¿½Â¯
		gm = gmList.get(0);
		return "ajaxGetGtmAndGm";
	}
	
	//Ã©Å“â‚¬Ã¨Â¦ï¿½Ã¨Â¿â€¡Ã¦Â»Â¤Ã¥Â·Â²Ã§Â»ï¿½Ã¤Â½Â¿Ã§â€�Â¨Ã§Å¡â€žÃ¦â€¢Â°Ã¦ï¿½Â®
	public String ajaxGetGtmAndGm2(){
		//Ã¨Â§Â£Ã¦Å¾ï¿½Ã¥â€¡ÂºÃ¥Â·Â²Ã§Â»ï¿½Ã¤Â½Â¿Ã§â€�Â¨Ã§Å¡â€žÃ¥â€¢â€ Ã¥â€œï¿½Ã¥Â¯Â¹Ã¥Âºâ€�Ã§Å¡â€žuuid
		String[] uuidsArr = used.split(",");
		//Ã¥Â°â€ Ã¤Â½Â¿Ã§â€�Â¨Ã¨Â¿â€¡Ã§Å¡â€žÃ¥â€¢â€ Ã¥â€œï¿½ uuidÃ¨Â½Â¬Ã¦ï¿½Â¢Ã¤Â¸ÂºÃ¤Â¸â‚¬Ã¤Â¸ÂªÃ¦â€¢Â°Ã§Â»â€ž/Ã©â€ºâ€ Ã¥ï¿½Ë†
		Set<Long> uuids = new HashSet<Long>();
		for(String uuidStr:uuidsArr){
			uuids.add(new Long(uuidStr));
		}
		
		//Ã¦Â Â¹Ã¦ï¿½Â®Ã¤Â¾â€ºÃ¥Âºâ€�Ã¥â€¢â€ Ã§Å¡â€žuuidÃ¨Å½Â·Ã¥ï¿½â€“Ã§Â±Â»Ã¥Ë†Â«Ã¦â€¢Â°Ã¦ï¿½Â®Ã¤Â¸Å½Ã¥â€¢â€ Ã¥â€œï¿½Ã¦â€¢Â°Ã¦ï¿½Â®
		//Ã§Â±Â»Ã¥Ë†Â«Ã¤Â¸Â­Ã¥Â¿â€¦Ã©Â¡Â»Ã¦Å“â€°Ã¥â€¢â€ Ã¥â€œï¿½
		gtmList = goodsTypeEbi.getAllUnionBySupplier(supplierUuid);
		//1.Ã¥Â¦â€šÃ¦Å¾Å“Ã§Â±Â»Ã¥Ë†Â«Ã¤Â¸Â­Ã§Å¡â€žÃ¦â€°â‚¬Ã¦Å“â€°Ã¥â€¢â€ Ã¥â€œï¿½Ã©Æ’Â½Ã¤Â½Â¿Ã§â€�Â¨Ã¨Â¿â€¡Ã¯Â¼Å’Ã¨Â¯Â¥Ã§Â±Â»Ã¥Ë†Â«Ã¥Ë†Â Ã©â„¢Â¤
		//1.xÃ¥Â¦â€šÃ¦Å¾Å“Ã§Â±Â»Ã¥Ë†Â«Ã¤Â¸Â­Ã¦Å¸ï¿½Ã¤Â¸ÂªÃ¥â€¢â€ Ã¥â€œï¿½Ã¦Â²Â¡Ã¦Å“â€°Ã¤Â½Â¿Ã§â€�Â¨Ã¨Â¿â€¡Ã¯Â¼Å’Ã¨Â¯Â¥Ã§Â±Â»Ã¥Ë†Â«Ã¤Â¿ï¿½Ã§â€¢â„¢
		int flag=0;
		for(int i = gtmList.size()-1;i>=0;i--){
			flag = 0;
			GoodsTypeModel gtm = gtmList.get(i);
			//æ ¹æ�®å•†å“�ç±»åˆ«èŽ·å�–å•†å“�
			gmList = goodsEbi.getAllByGtmUuid(gtm.getUuid());
			for(GoodsModel temp:gmList){
				if(!uuids.contains(temp.getUuid())){
					flag = 1;
					continue;
				}
			}
			//è¯¥ç±»åˆ«ä¸­æ‰€æœ‰å•†å“�å…¨éƒ¨ä½¿ç”¨è¿‡
			if(flag ==1){
				continue;
			} else gtmList.remove(i);
		}

		
		//Ã¦Â Â¹Ã¦ï¿½Â®Ã§Â¬Â¬Ã¤Â¸â‚¬Ã¤Â¸ÂªÃ¥â€¢â€ Ã¥â€œï¿½Ã§Â±Â»Ã¥Ë†Â«Ã¨Å½Â·Ã¥ï¿½â€“Ã¥Â¯Â¹Ã¥Âºâ€�Ã§Å¡â€žÃ¦â€°â‚¬Ã¦Å“â€°Ã¥â€¢â€ Ã¥â€œï¿½
		gmList = goodsEbi.getAllByGtmUuid(gtmList.get(0).getUuid());
		//Ã¥Ë†Â Ã©â„¢Â¤Ã¦Å½â€°Ã¥Â·Â²Ã§Â»ï¿½Ã¤Â½Â¿Ã§â€�Â¨Ã¨Â¿â€¡Ã§Å¡â€žÃ¥â€¢â€ Ã¥â€œï¿½
		for(int i = gmList.size()-1;i>=0;i--){
			GoodsModel gm = gmList.get(i);
			if(uuids.contains(gm.getUuid())){
				//Ã¨Â¯Â¥Ã¥â€¢â€ Ã¥â€œï¿½Ã¥Â·Â²Ã§Â»ï¿½Ã¤Â½Â¿Ã§â€�Â¨Ã¨Â¿â€¡
				gmList.remove(i);
			}
		}
		
		//Ã¨Å½Â·Ã¥ï¿½â€“Ã§Â¬Â¬Ã¤Â¸â‚¬Ã¤Â¸ÂªÃ¥â€¢â€ Ã¥â€œï¿½Ã¤Â¿Â¡Ã¦ï¿½Â¯
		gm = gmList.get(0);
		return "ajaxGetGtmAndGm";
	}
	
	public String ajaxGetGm(){
		gmList = goodsEbi.getAllByGtmUuid(goodsTypeUuid);
		gm = gmList.get(0);
		return "ajaxGetGm";
	}
	
	public String ajaxGetOne(){
		gm = goodsEbi.get(goodsUuid);
		return "ajaxGetOne";
	}
	
	public Long[] goodsUuids;
	public Integer[] nums;
	public Double[] prices;
	
	//Ã§â€�Å¸Ã¦Ë†ï¿½Ã©â€¡â€¡Ã¨Â´Â­Ã¨Â®Â¢Ã¥ï¿½â€¢
	public String buyOrder(){
		//Ã¦â€�Â¶Ã©â€ºâ€ Ã©Â¡ÂµÃ©ï¿½Â¢Ã§Å¡â€žÃ¥â‚¬Â¼
		//om.sm.uuid->om
		/*
		System.out.println(om.getSm().getUuid());
		System.out.println("-----------------");
		for(Long temp:goodsUuids){
			System.out.println(temp);
		}
		System.out.println("-----------------");
		for(Integer temp:nums){
			System.out.println(temp);
		}
		System.out.println("-----------------");
		for(Double temp:prices){
			System.out.println(temp);
		}
		*/
		orderEbi.save(getLogin(),om,goodsUuids,nums,prices);
		return TO_LIST;
	}
	
	public String buyDetailList(){
		om = orderEbi.get(om.getUuid());
		return "buyDetailList";
	}
	
	//--Ã¥Â®Â¡Ã¦Â Â¸Ã§â€ºÂ¸Ã¥â€¦Â³----------------------
	
	/**
	 * 
	 * @param check insert 0 to get buyCheck, 1 to get toBuyCheckDetail, 2 to get buyCheckPass, 3 to get buyCheckNoPass
	 * @return a string with the desidered value
	 */
	public String Check(int check){
		String toReturn = null;
		if (check==0) {
		setDataTotal(orderEbi.getCountByTypes(oqm));
		List<OrderModel> orderList = orderEbi.getAllNoCheckOrder(oqm,pageNum,pageCount);
		put("orderList",orderList);
		toReturn= "buyCheck";
		}
		//Ã¨Â½Â¬Ã¥Ë†Â°Ã¥Â®Â¡Ã¦Â Â¸Ã¨Â¯Â¦Ã¦Æ’â€¦Ã©Â¡Âµ
		else if (check==1) {
			//Ã¦Â Â¹Ã¦ï¿½Â®Ã¨Â®Â¢Ã¥ï¿½â€¢Ã§Å¡â€žuuidÃ¨Å½Â·Ã¥ï¿½â€“Ã¨Â®Â¢Ã¥ï¿½â€¢Ã¦â€¢Â°Ã¦ï¿½Â®
			om = orderEbi.get(om.getUuid());
			toReturn = "toBuyCheckDetail";
		}
		//Ã©â€¡â€¡Ã¨Â´Â­Ã¥Â®Â¡Ã¦Â Â¸Ã©â‚¬Å¡Ã¨Â¿â€¡
		else if (check==2) {
			orderEbi.buyCheckPass(om.getUuid(),getLogin());
			toReturn = "toBuyCheck";
		}
		//Ã©â€¡â€¡Ã¨Â´Â­Ã¥Â®Â¡Ã¦Â Â¸Ã©Â©Â³Ã¥â€ºÅ¾
		else if (check==3) {
			orderEbi.buyCheckNoPass(om.getUuid(),getLogin());
			toReturn = "toBuyCheck";
		}
		else {
			toReturn = "The Value is not correct, please read documentation!";
		}
		return toReturn;
	}

	/**
	 * 
	 * @param check insert 0 to get assignTask, 1 to get assignTaskList, 2 to get assignTaskDetail
	 * @return a string with the desidered value
	 */
	//Ã¦Å’â€¡Ã¦Â´Â¾Ã¥â€¦Â·Ã¤Â½â€œÃ¤Â»Â»Ã¥Å Â¡Ã¤ÂºÂº
	public String assignTask(int check){
		String toReturn = null;
		if (check==0) {
		//Ã¦Å’â€¡Ã¦Â´Â¾Ã¤Â»Â»Ã¥Å Â¡Ã¤ÂºÂº  om.uuid   om.completer.uuid
		orderEbi.assignTask(om);
		toReturn = "toAssignTaskList";
		} else
		if (check ==1) {
			//Ã¨Å½Â·Ã¥ï¿½â€“Ã¥Â¾â€¦Ã¥Ë†â€ Ã©â€¦ï¿½Ã§Å¡â€žÃ¤Â»Â»Ã¥Å Â¡Ã¦â€¢Â°Ã¦ï¿½Â®Ã©â€ºâ€ Ã¥ï¿½Ë†
			List<OrderModel> orderList = orderEbi.getAllTasks(oqm,pageNum,pageCount);
			put("orderList",orderList);
			//Ã¨Â·Â³Ã¨Â½Â¬Ã©Â¡ÂµÃ©ï¿½Â¢
			return "assignTaskList";
		}
		else if (check ==2) {
			//Ã¥Å Â Ã¨Â½Â½Ã¨Â¿ï¿½Ã¨Â¾â€œÃ©Æ’Â¨Ã©â€”Â¨Ã§Å¡â€žÃ¦â€°â‚¬Ã¦Å“â€°Ã¥â€˜ËœÃ¥Â·Â¥
			Long depUuid = getLogin().getDm().getUuid();
			List<EmpModel> empList = empEbi.getAllByDep(depUuid);
			put("empList",empList);
			om = orderEbi.get(om.getUuid());
			return "assignTaskDetail";
		}
		else {
			toReturn = "The Value is not correct, please read documentation!";
		}
		return toReturn;
	}
	
	public String queryTask(){
		//Ã¦Â Â¹Ã¦ï¿½Â®Ã§â„¢Â»Ã©â„¢â€ Ã¤ÂºÂºÃ¤Â¿Â¡Ã¦ï¿½Â¯Ã¨Å½Â·Ã¥ï¿½â€“Ã¥Â¯Â¹Ã¥Âºâ€�Ã§Å¡â€žÃ¤Â»Â»Ã¥Å Â¡Ã¥Ë†â€”Ã¨Â¡Â¨
		List<OrderModel> orderList = orderEbi.getAllByCompleter(oqm,pageNum,pageCount,getLogin());
		put("orderList",orderList);
		return "queryTask";
	}
	
	public String toTaskDetail(){
		om = orderEbi.get(om.getUuid());
		return "toTaskDetail";
	}
	
	public String completeTask(){
		orderEbi.endTask(om.getUuid());
		return "toQueryTask";
	}
	
	//--Ã¤Â»Â»Ã¥Å Â¡Ã¥Ë†â€ Ã©â€¦ï¿½Ã§Â»â€œÃ¦ï¿½Å¸----------------------
	
	//Ã¤Â»â€œÃ¥Âºâ€œÃ¥â€¦Â¥Ã¥Âºâ€œ
	public String inGoodsList(){
		//Ã¥Â±â€¢Ã§Â¤ÂºÃ¦â€°â‚¬Ã¦Å“â€°Ã¦Â²Â¡Ã¦Å“â€°Ã¥â€¦Â¥Ã¥Âºâ€œÃ¥Â®Å’Ã¦Â¯â€¢Ã§Å¡â€žÃ¨Â®Â¢Ã¥ï¿½â€¢Ã¦â€¢Â°Ã¦ï¿½Â®
		List<OrderModel> orderList = orderEbi.getAllNotIn(oqm,pageNum,pageCount);
		put("orderList",orderList);
		return "inGoodsList";
	}
	public String inGoodsDetail(){
		//Ã¥Å Â Ã¨Â½Â½Ã¦â€°â‚¬Ã¦Å“â€°Ã¤Â»â€œÃ¥Âºâ€œÃ¦â€¢Â°Ã¦ï¿½Â®
		List<StoreModel> storeList = storeEbi.getAll();
		put("storeList",storeList);
		om = orderEbi.get(om.getUuid());
		return "inGoodsDetail";
	}
	
	//--Ã¥â€¦Â¥Ã¥Âºâ€œ--------------------------------
	public Long odmUuid;
	private OrderDetailModel odm;
	
	public OrderDetailModel getOdm() {
		return odm;
	}

	public String ajaxGetSurplusByOdmUuid(){
		//Ã¦Â Â¹Ã¦ï¿½Â®odmUuidÃ¨Å½Â·Ã¥ï¿½â€“Ã¥Â¯Â¹Ã¥Âºâ€�Ã§Å¡â€žÃ¨Â´Â§Ã§â€°Â©Ã¥â€°Â©Ã¤Â½â„¢Ã¦â€¢Â°Ã©â€¡ï¿½
		odm = orderDetailEbi.get(odmUuid);
		return "ajaxGetSurplusByOdmUuid";
	}
}
