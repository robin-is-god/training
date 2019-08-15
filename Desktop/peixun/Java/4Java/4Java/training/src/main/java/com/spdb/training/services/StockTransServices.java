package com.spdb.training.services;

import java.util.List;

import com.spdb.training.beans.stock.Stock;
import com.spdb.training.beans.stock.StockRsp;
import com.spdb.training.beans.trans.TransReqContext;
import com.spdb.training.beans.trans.TransRspContext;
import com.spdb.training.exception.BusinessException;
import com.spdb.training.log.ILog;
import com.spdb.training.log.LoggerFactory;
import com.spdb.training.services.stock.StockServiceImpl;

/**
* @ClassName: StockTransServices
* @Description: TODO:
* @author Robin
* @date 2019年8月15日
*
*/

public class StockTransServices implements ITransServices<Stock, StockRsp>{

	ILog log = LoggerFactory.getLogger(StockTransServices.class);
	private StockServiceImpl stockServiceImpl;
	
	@Override
	public void execute(TransReqContext<Stock> reqContext, TransRspContext<StockRsp> rspContext) {
		// 实锟斤拷锟斤拷锟斤拷锟斤拷锟酵拷锟絊pring注锟斤拷
		if (stockServiceImpl == null) {
			stockServiceImpl = new StockServiceImpl();
		}

		List<Stock> row = stockServiceImpl.queryStockHaveQty();
		if (row == null || row.isEmpty()) {
			throw new BusinessException(ResultCodeEnum.TRAINPB0002.getCode(), ResultCodeEnum.TRAINPB0002.getMsg(),
					"");
		} else {
			log.info("查询到的所有商品库存信息如下:{}", row.toString());
		}

		StockRsp context = rspContext.getContext();
		context.setNum(row.size());
		context.setRow(row);
	}
}
