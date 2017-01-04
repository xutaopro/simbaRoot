package com.caozj.interfaces.impl;

import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.xerces.dom.DeferredElementImpl;

import com.caozj.interfaces.ParseWxXML;
import com.caozj.model.wx.receive.BaseReceiveObject;
import com.caozj.model.wx.receive.msg.VoiceMessage;
import com.caozj.util.common.ParseUtil;

public class VoiceParse implements ParseWxXML {

	@Override
	public BaseReceiveObject parse(DeferredElementImpl root) throws XPathExpressionException {
		VoiceMessage message = new VoiceMessage();
		message.setToUserName(ParseUtil.getToUserName(root));
		message.setFromUserName(ParseUtil.getFromUserName(root));
		message.setMsgId(ParseUtil.getMsgId(root));
		message.setCreateTime(NumberUtils.toLong(ParseUtil.getCreateTime(root)));
		message.setMsgType(ParseUtil.getMsgType(root));
		message.setMediaId(ParseUtil.getValue(root, "MediaId"));
		message.setFormat(ParseUtil.getValue(root, "Format"));
		return message;
	}

}
