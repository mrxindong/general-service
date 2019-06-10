package com.znzd.charging.common.core.util;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;
import java.util.Set;


public class ResultUtil {


	private static RedisTemplate<String, Object> redisTemplate = SpringContextHolder.getBean("redisTemplate");

	/**
	 * 微信小程序返回的结果用这个包装一下，小程序原代码就不用动，保持格式与nodejs相同
	 * 封装结果返回
	 */
	public static Map<String, Object> getResultMap() {
		Map<String, Object> resultMap = Maps.newHashMap();
		resultMap.put("msg", "");
		resultMap.put("success", true);
		return resultMap;
	}


	/**
	 * 解析wxToken 缓存在redis中的数据
	 *
	 * @param wxToken
	 * @return
	 */
	public static Map<String, String> analysisWxToken(String wxToken) {
		Map<String, String> extraParams = Maps.newHashMapWithExpectedSize(3);
		if (StringUtils.isNotBlank(wxToken)) {
			Object wxTokenInRedis = redisTemplate.opsForValue().get(wxToken);
			if (ObjectUtil.isNotNull(wxTokenInRedis)) {
				JSONObject wxInfo = JSONUtil.parseObj((String) wxTokenInRedis);
				Object wxUserId = wxInfo.get("wxUserId");
				String sessionKey = (String) wxInfo.get("session_key");
				String openId = (String) wxInfo.get("openid");

				extraParams.put("openId", openId);
				extraParams.put("sessionKey", sessionKey);
				if (null != wxUserId) {
					extraParams.put("wxUserId", wxUserId + "");
				}
			}
		}
		return extraParams;
	}


	/**
	 * String 转 Integer
	 *
	 * @param strValue
	 * @return
	 */
	public static Integer getIntegerValue(String strValue) {
		if(StrUtil.isBlank(strValue)){
			return null;
		}
		return Integer.valueOf(strValue);
	}


}
