package com.fjx.wechat.mysdk.process.in.executor;

import com.fjx.wechat.base.constants.WechatReqEventConstants;
import com.fjx.wechat.base.constants.WechatReqMsgtypeConstants;
import com.fjx.wechat.base.context.WechatContext;
import com.fjx.wechat.base.process.in.executor.*;
import com.fjx.wechat.base.tools.ServiceTool;
import com.fjx.wechat.base.vo.req.ReqEventMessage;


/**
 * 菜单点击消息处理器
 * @author fengjx xd-fjx@qq.com
 * @date 2014年9月11日
 */
public class InWechatEventClickMsgExecutor extends com.fjx.wechat.base.process.in.executor.InServiceExecutor {

	@Override
	public String execute() throws Exception {
		ReqEventMessage eventMessage = new ReqEventMessage(WechatContext.getWechatPostMap());
		logger.info("进入菜单点击消息处理器fromUserName="+eventMessage.getFromUserName());
		return doAction(null, eventMessage.getMsgType(), eventMessage.getEvent(), eventMessage.getEventKey());
	}

	@Override
	public String getExecutorName() {
		return ServiceTool.buildInServiceName(WechatReqMsgtypeConstants.REQ_MSG_TYPE_EVENT,
				WechatReqEventConstants.EVENT_TYPE_CLICK);
	}

}